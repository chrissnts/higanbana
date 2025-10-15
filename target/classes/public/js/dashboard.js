const sidebarItems = document.querySelectorAll(".sidebar-item");
const cardContents = document.querySelectorAll(".card-content");

function showSection(targetId) {
  cardContents.forEach((content) => {
    content.style.display = content.id === targetId ? "block" : "none";
  });

  // Atualiza a classe ativa na sidebar
  sidebarItems.forEach((item) => {
    item.classList.toggle("active", item.dataset.target === targetId);
  });
}

// Inicial: mostrar Animes
showSection("animes");

// Evento de clique
sidebarItems.forEach((item) => {
  item.addEventListener("click", () => {
    if (item.dataset.target === "logout") {
      // dispara o formulário de logout
      document.getElementById("logoutForm").submit();
    } else {
      showSection(item.dataset.target);
    }
  });
});


function setupSearch(inputId, tableId) {
  const searchInput = document.getElementById(inputId);
  searchInput.addEventListener("keyup", function () {
    const filter = searchInput.value.toLowerCase();
    const rows = document.querySelectorAll(`#${tableId} tbody tr`);
    rows.forEach((row) => {
      const name = row.cells[1].textContent.toLowerCase();
      row.style.display = name.includes(filter) ? "" : "none";
    });
  });
}

// Configura as buscas
setupSearch("animeSearch", "animes");
setupSearch("userSearch", "users");
setupSearch("studioSearch", "studios"); 
