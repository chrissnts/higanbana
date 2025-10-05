<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Higanbana - Home</title>
  <link rel="icon" type="image/png" href="/img/tokyoFlower.jpeg" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="/styles/home.css" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>
  <nav class="navbar navbar-expand-lg py-2 px-3">
    <div class="container-fluid">
      <a class="navbar-brand d-flex align-items-center text-white" href="#">
        <img class="logo" src="/img/tokyoFlower.jpeg" alt="Logo" />
        <strong class="ms-2">Higanbana</strong>
      </a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarAnime"
        aria-controls="navbarAnime" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarAnime">
        <ul class="navbar-nav ms-auto align-items-center mb-2 mb-lg-0">
          <li class="nav-item me-3">
            <a class="nav-link text-uppercase fw-bold text-white" href="/animes">ANIMES</a>
          </li>
          <li class="nav-item me-3">
            <a class="nav-link text-uppercase fw-bold text-white" href="/lists">LISTS</a>
          </li>
          <li class="nav-item me-3">
            <a class="nav-link text-uppercase fw-bold text-white" href="/watchlist">WATCHLIST</a>
          </li>
          <li class="nav-item me-3">
            <a class="nav-link text-white" href="/search"><i class="bi bi-search"></i></a>
          </li>
          <li class="nav-item me-3">
            <button class="btn btn-success btn-sm px-3 fw-bold">+ LOG</button>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle d-flex align-items-center text-white" href="#" id="navbarUser"
              role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="/img/profile.jpeg" class="rounded-circle me-2" alt="Avatar" width="30" height="30" />
              <span class="text-uppercase fw-bold text-white">${user.userName}</span>
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li><a class="dropdown-item" href="/profile">Profile</a></li>
              <li><a class="dropdown-item" href="/favorites">Favorites</a></li>
              <li><a class="dropdown-item" href="/activity">Activity</a></li>
              <li><a class="dropdown-item" href="/settings">Settings</a></li>
              <li>
                <hr class="dropdown-divider" />
              </li>
              <li><a class="dropdown-item" href="/logout">Sign Out</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container text-center mt-4">
    <h2>Welcome Back, <a href="/profile" class="text-info">${user.userName}</a></h2>
    <p class="text-muted">Look what you're friends watching...</p>
  </div>

  <div class="container mt-5">
    <h5>NEW FROM FRIENDS</h5>
    <hr>
    <div class="scrolling-wrapper mt-2 d-flex flex-row gap-4 overflow-auto bg-gradient text-white px-3 py-2">
      <div class="d-flex flex-column align-items-center p-2 rounded shadow-sm bg-light ">
        <img class="anime-card rounded"
          src="https://images-cdn.ubuy.co.in/633ff1157e3fbc25557517c8-one-piece-poster-japanese-anime-posters.jpg"
          alt="Anime Poster" />
        <div class="mt-2 text-center">
          <div class="d-flex align-items-center justify-content-center gap-2">
            <img src="https://i.pinimg.com/736x/65/ee/1c/65ee1ca15ea1de2fc176f6c654a503e3.jpg" alt="Profile Pic" class="rounded-circle" width="30"
              height="30" />
            <small class="fw-semibold">soldier34 • ⭐⭐⭐⭐⭐</small>
          </div>
          <small class="text-muted">1 de Junho</small>
        </div>
      </div>

      <div class="d-flex flex-column align-items-center p-2 rounded shadow-sm bg-light">
        <img class="anime-card rounded" src="https://www.grindstore.com/cdn/shop/files/147081-front.jpg?v=1711028581"
          alt="Anime Poster" />
        <div class="mt-2 text-center">
          <div class="d-flex align-items-center justify-content-center gap-2">
            <img src="https://i.pinimg.com/736x/d7/8a/41/d78a41bd80994a13b3d54256c3f2a477.jpg" alt="Profile Pic" class="rounded-circle" width="30" height="30" />
            <small class="fw-semibold">bigcorleone • ⭐⭐⭐⭐☆</small>
          </div>
          <small class="text-muted">28 de Maio</small>
        </div>
      </div>

      <div class="d-flex flex-column align-items-center p-2 rounded shadow-sm bg-light">
        <img class="anime-card rounded" src="https://upload.wikimedia.org/wikipedia/pt/d/d0/Tonari_no_Totoro_p%C3%B4ster.png"
          alt="Anime Poster" />
        <div class="mt-2 text-center">
          <div class="d-flex align-items-center justify-content-center gap-2 text-white">
            <img src="https://i.pinimg.com/736x/f6/93/a4/f693a4c50bbcf54c8bdc9b714dc8d8b8.jpg" alt="Profile Pic" class="rounded-circle" width="30" height="30" />
            <small class="fw-semibold">Luana • ⭐⭐⭐☆☆</small>
          </div>
          <small class="text-muted">27 de Junho</small>
        </div>
      </div>

      <div class="d-flex flex-column align-items-center p-2 rounded shadow-sm bg-light">
        <img class="anime-card rounded" src="https://m.media-amazon.com/images/I/6103u5u-alL.jpg"
          alt="Anime Poster" />
        <div class="mt-2 text-center">
          <div class="d-flex align-items-center justify-content-center gap-2 text-white">
            <img src="https://i.pinimg.com/736x/fb/8c/cd/fb8ccd0ec32fd1cb53a0bf78fe48076e.jpg" alt="Profile Pic" class="rounded-circle" width="30" height="30" />
            <small class="fw-semibold">Rudaaa</small>
          </div>
          <small class="text-muted">27 de Junho</small>
        </div>
      </div>
    </div>
    </div>
  </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
