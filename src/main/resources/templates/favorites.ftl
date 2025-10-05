<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Higabana - Home</title>
  <link rel="icon" type="image/png" href="/img/tokyoFlower.jpeg" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="/styles/favorites.css" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>
  <nav class="navbar navbar-expand-lg py-2 px-3">
    <div class="container-fluid">
      <a class="navbar-brand d-flex align-items-center text-white" href="home.html">
        <img class="logo" src="/img/tokyoFlower.jpeg" alt="Logo" />
        <strong class="ms-2">Higabana</strong>
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

 

  <div class="container mt-4">
    <h2 class="text-center">Favorites</h2>
    
    <ul class="nav nav-tabs justify-content-center mt-4" id="favoritesTabs" role="tablist">
      <li class="nav-item" role="presentation">
        <button class="nav-link active btn-color text-light" id="animes-tab" data-bs-toggle="tab" data-bs-target="#animes" type="button"
          role="tab">Animes</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link btn-color text-light" id="reviews-tab" data-bs-toggle="tab" data-bs-target="#reviews" type="button"
          role="tab">Reviews</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link btn-color text-light" id="lists-tab" data-bs-toggle="tab" data-bs-target="#lists" type="button"
          role="tab">Lists</button>
      </li>
    </ul>

    <div class="tab-content mt-4" id="favoritesTabsContent">

      <div class="tab-pane fade show active" id="animes" role="tabpanel">

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-5 g-4 justify-content-center">

          <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://m.media-amazon.com/images/I/6103u5u-alL.jpg" alt="Death Note" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

           <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://m.media-amazon.com/images/M/MV5BZWZlMTFjNDgtYTdkOC00MmYxLTk0YmEtZGQ4NmE5MTM3OTg0XkEyXkFqcGc@._V1_.jpg" alt="Fire Force" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐️⭐️⭐️⭐️⯨</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

           <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://upload.wikimedia.org/wikipedia/pt/3/3b/A_Viagem_de_Chihiro.JPG" alt="chihiro" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

           <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://images.justwatch.com/poster/102012613/s718/tokyo-ghoul.jpg" alt="Tokyo Ghoul" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

           <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://xonomax.com/cdn/shop/files/750407.jpg?v=1721570733" alt="tokyo Revengers" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

           <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://img.elo7.com.br/product/main/26A822C/big-poster-anime-demon-slayer-kimetsu-no-yaiba-lo12-90x60-cm-poster-anime.jpg" alt="Demon Slayer" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

          <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://static.jojowiki.com/images/thumb/5/51/latest/20210407134012/JoJo%27s_Bizarre_Adventure_The_Animation_International_Poster.png/800px-JoJo%27s_Bizarre_Adventure_The_Animation_International_Poster.png" alt="Jojo" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⯨</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

          <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://a.storyblok.com/f/178900/750x1066/3f76801ffc/cr_aot_key.png/m/filters:quality(95)format(webp)" alt="Attack on Titan" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

          <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://a.storyblok.com/f/178900/960x1440/0e7797b5d5/bluelockepisodenagi_2x3_2000x3000.jpg/m/filters:quality(95)format(webp)" alt="Blue Lock" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>

          <div class="col">
            <div class="card bg-anime text-white border-0" style="max-width: 160px;">
              <img src="https://m.media-amazon.com/images/M/MV5BZDNmNzljMzEtOTM5Ny00NWU0LThkNTEtMzJlZDhjYjQxOTAxXkEyXkFqcGc@._V1_.jpg" alt="The Quintessential Quintuplets" class="img-fluid rounded">
              <div class="card-body text-center p-2">
                <div class="stars mb-1" style="font-size: 0.85rem;">⭐⭐⭐⭐⭐</div>
                <div class="text-danger" style="font-size: 1rem;">❤</div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="tab-pane fade" id="reviews" role="tabpanel">
        <div class="text-center text-muted">
          <p>No reviews favorited yet.</p>
        </div>
      </div>

      
      <div class="tab-pane fade" id="lists" role="tabpanel">
        <div class="text-center text-muted">
          <p>No lists favorited yet.</p>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>