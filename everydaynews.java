async function getNews() {
    const category = document.getElementById('category').value;
    const apiKey = 'your_api_key'; // Sostituisci con la tua chiave API di NewsAPI
    const url = `https://newsapi.org/v2/top-headlines?category=${category}&country=it&apiKey=${apiKey}`;

    try {
        const response = await fetch(url);
        const data = await response.json();

        const newsContainer = document.getElementById('news-container');
        newsContainer.innerHTML = '';  // Pulisce la sezione notizie

        data.articles.forEach(article => {
            const newsItem = document.createElement('div');
            newsItem.classList.add('news-item');
            newsItem.innerHTML = `
                <h2>${article.title}</h2>
                <p>${article.description}</p>
                <a href="${article.url}" target="_blank">Leggi di più</a>
            `;
            newsContainer.appendChild(newsItem);
        });
    } catch (error) {
        console.error('Errore nel recuperare le notizie', error);
    }
}

// Carica le notizie al caricamento della pagina
window.onload = getNews;