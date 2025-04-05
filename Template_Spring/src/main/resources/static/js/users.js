const apiUrl = '/users';

function getUsers() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const usersUl = document.getElementById('usersUl');
            usersUl.innerHTML = '';
            data.forEach(user => {
                const li = document.createElement('li');
                li.textContent = `${user.name} (${user.email})`;
                usersUl.appendChild(li);
            });
        });
}

function createUser(event) {
    event.preventDefault();

    const user = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(user)
    }).then(() => {
        getUsers();
        document.getElementById('userForm').reset();
    });
}

window.onload = () => getUsers();
