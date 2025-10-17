<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Higanbana - Rate Anime and Share Opinions</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700;900&display=swap" rel="stylesheet">
  <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
  <link rel="stylesheet" href="/styles/style.css" />
</head>

<body>
  <div class="vertical-text d-none d-md-block">
    Higanbana - Rate Anime and Share Opinions
  </div>

  <nav class="navbar navbar-expand-lg position-absolute top-0 start-0 end-0 z-3 p-4">
    <div class="container">
      <a class="navbar-brand me-auto nav-logo">Higanbana</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link" href="/login">SIGN IN</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/register">Register</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/about">ABOUT US</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="main-wrapper d-flex justify-content-center align-items-center vh-100 p-3">

    <div class="hero-card shadow-lg">

      <div class="row g-0 h-100 hero-section">

        <div class="col-md-6 d-none d-md-flex hero-image-col">
          <img src="/img/wallpaper.png" alt="Hero Wallpaper" class="hero-image animate-img" />
        </div>

        <div class="col-12 col-md-6 hero-content-col d-flex align-items-center justify-content-center">
          <div class="content-wrapper p-4 p-lg-5 text-center text-md-start"> 
            <h1 class="hero-title mb-4">
              <span class="jp-text d-block">ヒガンバナ</span>
              Higanbana
            </h1>
            <p class="hero-subtitle mb-5 mx-auto mx-md-0">
              Share your thoughts and rate the anime series you love—let the community know your favorites!
            </p>
            <a href="/login" class="btn btn-get-started">
              Get Started &nbsp; →
            </a>
           
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>