// books.js

// Fetch the books from the API and display them
const apiUrl = '/books';  // Replace with your API endpoint

// Fetch books and display them
function getBooks() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const booksList = document.getElementById('booksList');
            booksList.innerHTML = ''; // Clear the previous list of books
            data.forEach(book => {
                const bookElement = document.createElement('div');
                bookElement.classList.add('book-item');
                bookElement.innerHTML = `
                    <img src="images/book${book.id}.png" alt="${book.title}" class="book-cover">
                    <div class="book-details">
                        <h3>${book.title}</h3>
                        <p>Author: ${book.author}</p>
                    </div>
                `;
                booksList.appendChild(bookElement);
            });
        })
        .catch(error => console.error('Error fetching books:', error));
}

// Filter books based on search input
function filterBooks() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const booksList = document.getElementById('booksList');
    const bookItems = booksList.getElementsByClassName('book-item');

    for (let i = 0; i < bookItems.length; i++) {
        const bookTitle = bookItems[i].getElementsByTagName('h3')[0].textContent.toLowerCase();
        if (bookTitle.includes(searchInput)) {
            bookItems[i].style.display = '';
        } else {
            bookItems[i].style.display = 'none';
        }
    }
}

// Call getBooks when the page is loaded
window.onload = getBooks;
