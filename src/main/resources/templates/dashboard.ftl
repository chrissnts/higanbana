<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Higanbana - Admin Dashboard</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/dashboard.css" />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>
    <nav class="navbar navbar-expand-lg py-2 px-3">
        <div class="container-fluid">
            <a class="navbar-brand d-flex align-items-center text-white" href="#">
                <img src="/img/tokyoFlower.png" alt="Logo" class="rounded-circle me-2"
                    style="width: 35px; height: 35px" />
                <strong>Higanbana</strong>
            </a>

            <button class="navbar-toggler bg-white" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarAnime" aria-controls="navbarAnime" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarAnime">
                <ul class="navbar-nav ms-auto align-items-center mb-2 mb-lg-0">
                    <li class="nav-item me-3">
                        <a class="nav-link text-uppercase fw-bold text-white" href="#">DASHBOARD</a>
                    </li>

                    <li class="nav-item me-3">
                        <a class="nav-link text-uppercase fw-bold text-white" href="/users">USERS</a>
                    </li>

                    <li class="nav-item me-3">
                        <a class="btn btn-danger btn-sm py-lg-2 fw-bold" href="/animes">ANIMES</a>
                    </li>

                    <form class="d-flex gap-2 my-2 me-4" role="search">
                        <input class="form-control" type="search" placeholder="Search" aria-label="Search"
                            style="width: 150px" />
                        <button class="btn btn-danger py-lg-2" type="submit">Search</button>
                    </form>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle d-flex align-items-center text-white" href="#"
                            id="navbarUser" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="${admin.profileImage}" alt="Avatar" class="rounded-circle me-2" width="35"
                                height="35" />
                            <span class="fw-bold text-uppercase">${admin.userName}</span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarUser">
                            <li>
                                <form action="/logout" method="post" class="d-inline">
                                    <button type="submit" class="dropdown-item">
                                        Sign Out
                                    </button>
                                </form>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>