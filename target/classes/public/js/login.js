 const params = new URLSearchParams(window.location.search);
    const error = params.get("error");
    if (error) {
      const div = document.getElementById("login-error");
      div.textContent = error.replace(/\+/g, ' '); // substitui "+" por espaço
      div.classList.remove("d-none");
    }