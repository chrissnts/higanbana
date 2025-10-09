<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Higanbana - Home</title>
  <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="/styles/home.css" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg py-2 px-3">
    <div class="container-fluid">

      <!-- Logo -->
      <a class="navbar-brand d-flex align-items-center text-white" href="/home">
        <img src="/img/tokyoFlower.png" alt="Logo" class="rounded-circle me-2" style="width:35px;height:35px;" />
        <strong>Higanbana</strong>
      </a>

      <!-- Toggle -->
      <button  class="navbar-toggler bg-white" type="button" data-bs-toggle="collapse" data-bs-target="#navbarAnime"
        aria-controls="navbarAnime" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Navbar links -->
      <div class="collapse navbar-collapse" id="navbarAnime">
        <ul class="navbar-nav ms-auto align-items-center mb-2 mb-lg-0">

          <li class="nav-item me-3">
            <a class="nav-link text-uppercase fw-bold text-white" href="/animes">ANIMES</a>
          </li>

          <li class="nav-item me-3">
            <a class="nav-link text-uppercase fw-bold text-white" href="/watchlist">WATCHLIST</a>
          </li>

          <li class="nav-item me-3">
            <button class="btn btn-danger btn-sm px-3 fw-bold">+ LOG</button>
          </li>

          <!-- Search -->
          <form class="d-flex gap-2 my-2 me-4" role="search">
            <input class="form-control" type="search" placeholder="Search" aria-label="Search" style="width:150px;" />
            <button class="btn btn-danger" type="submit">Search</button>
          </form>

          <!-- User Dropdown -->
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle d-flex align-items-center text-white" href="#" id="navbarUser"
              role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="${user.profileImage}" alt="Avatar" class="rounded-circle me-2" width="35" height="35" />
              <span class="fw-bold text-uppercase">${user.userName}</span>
            </a>
            <ul class="dropdown-menu dropdown-menu-end text-white">
              <li><a class="dropdown-item" href="/profile">Profile</a></li>
              <li><a class="dropdown-item" href="/favorites">Favorites</a></li>
              <li><a class="dropdown-item" href="/activity">Activity</a></li>
              <li><a class="dropdown-item" href="/settings">Settings</a></li>
              <hr>
              <li>
                <form action="/logout" method="post" class="d-inline">
                  <button type="submit" class="dropdown-item">Sign Out</button>
                </form>
              </li>
            </ul>
          </li>

        </ul>
      </div>

    </div>
  </nav>

  <!-- Welcome Section -->
  <main class="container text-center mt-4">
    <h2>Welcome, <a href="/profile" class="text-red">${user.userName}</a></h2>
    <p class="text-muted">Look what your friends are watching...</p>
  </main>

  <!-- Friends’ Animes -->
  <section class="container mt-5">
    <h5>NEW FROM FRIENDS</h5>
    <hr />
    <div class="scrolling-wrapper mt-2 d-flex flex-row gap-4 overflow-auto bg-gradient text-white px-3 py-2">

      <!-- Anime Card Template -->
      <article class="d-flex flex-column align-items-center p-2 rounded shadow-sm bg-light">
        <img class="anime-card rounded"
          src="https://images-cdn.ubuy.co.in/633ff1157e3fbc25557517c8-one-piece-poster-japanese-anime-posters.jpg"
          alt="Anime Poster" />
        <div class="mt-2 text-center">
          <div class="d-flex align-items-center justify-content-center gap-2">
            <img src="https://i.pinimg.com/736x/65/ee/1c/65ee1ca15ea1de2fc176f6c654a503e3.jpg" alt="Profile Pic"
              class="rounded-circle" width="30" height="30" />
            <small class="fw-semibold">soldier34 • ⭐⭐⭐⭐⭐</small>
          </div>
          <small class="text-muted">1 de Junho</small>
        </div>
      </article>

      <!-- Repetir os cards conforme necessário -->
    </div>
  </section>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>