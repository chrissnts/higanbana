<nav class="navbar navbar-expand-lg py-2 px-3 fixed-top">
  <div class="container-fluid">


    <a class="navbar-brand d-flex align-items-center text-white" href="/home">
      <img src="/img/tokyoFlower.png" alt="Logo" class="rounded-circle me-2" style="width:35px;height:35px;" />
      <strong>Higanbana</strong>
    </a>


    <button class="navbar-toggler bg-white" type="button" data-bs-toggle="collapse" data-bs-target="#navbarAnime"
      aria-controls="navbarAnime" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>


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


        <form class="d-flex gap-2 my-2 me-4" role="search">
          <input class="form-control" type="search" placeholder="Search" aria-label="Search" style="width:150px;" />
          <button class="btn btn-danger" type="submit">Search</button>
        </form>


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