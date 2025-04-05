const apiUrl = '/puntos';

function getPuntos() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const puntosUl = document.getElementById('puntosUl');
            puntosUl.innerHTML = '';
            data.forEach(punto => {
                const li = document.createElement('li');
                li.textContent = `${punto.location} (Contact: ${punto.contact})`;
                puntosUl.appendChild(li);
            });
        });
}

function createPuntoRecogida(event) {
    event.preventDefault();

    const punto = {
        location: document.getElementById('location').value,
        contact: document.getElementById('contact').value
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(punto)
    }).then(() => {
        getPuntos();
        document.getElementById('puntoForm').reset();
    });
}

window.onload = () => getPuntos();
