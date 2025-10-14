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
    <form id="logoutForm" action="/logout" method="post" style="display: none;"></form>
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

                    <li class="nav-item">
                        <a class="nav-link d-flex align-items-center text-white" href="/profile/${admin.id}">
                            <img src="${admin.profileImage}" alt="Avatar" class="rounded-circle me-2" width="35"
                                height="35" />
                            <span class="fw-bold text-uppercase">${admin.userName}</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>



    <div class="container-fluid pt-3">
        <div class="row">

            <div class="col-md-2">

                <div class="sidebar-menu d-flex justify-content-center flex-column text-white">
                    <div class="sidebar-item" data-target="users">
                        <i class="bi bi-people-fill me-2"></i> Users
                    </div>
                    <div class="sidebar-item" data-target="animes">
                        <i class="bi bi-film me-2"></i>
                        <span>Animes</span>
                    </div>
                    <div class="sidebar-item" data-target="reviews">
                        <i class="bi bi-chat-dots-fill me-2"></i>
                        <span></span>Reviews</span>
                    </div>
                    <div class="sidebar-item" data-target="analytics">
                        <i class="bi bi-bar-chart-fill me-2"></i>
                        <span>Analytics</span>
                    </div>
                    <div class="sidebar-item" data-target="settings">
                        <i class="bi bi-gear-fill me-2"></i>
                        <span>Settings</span>
                    </div>
                    <div class="sidebar-item" data-target="logout">
                        <i class="bi bi-box-arrow-right me-2"></i>
                        <span>Logout</span>
                    </div>
                </div>
            </div>


            <div class="col-md-7 ps-4 pe-2">
                <div class="main-card">

                    <div class="card-content" id="users">
                        <h5 class="fw-bold mb-3 text-uppercase">USER MANAGEMENT</h5>
                        <p>Conteúdo de usuários aqui...</p>
                    </div>


                    <div class="card-content" id="animes">
                        <h5 class="fw-bold mb-3 text-uppercase">ANIME MANAGEMENT</h5>
                        <a class="btn btn-danger mb-4 fw-bold" href="/animes/create">+ ADD NEW ANIME</a>

                        <div class="mb-3">
                        <input type="text" id="animeSearch" class="form-control" placeholder="Search">
                    </div>
                        <div class="table-responsive">

                            <table class="table align-middle mb-0 table-hover">

                                <thead class="text-white">
                                    <tr>
                                        <th class="fw-bold text-uppercase">ID</th>
                                        <th class="fw-bold text-uppercase">Title</th>
                                        <th class="fw-bold text-uppercase">Episodes</th>
                                        <th class="fw-bold text-uppercase">Avarage Rating</th>
                                        <th class="fw-bold text-uppercase">Actions</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <#list animes as anime>
                                        <tr class="${(anime_index % 2 == 0)?then('table-row-dark', 'table-row-light')}">
                                            <td>${anime.id}</td>
                                            <td class="fw-bold">${anime.title}</td>
                                            <td>${anime.episodesCount}</td>
                                            <td>${anime.rating}</td>
                                            <td class="d-flex gap-2">
                                                <a href="/animes/${anime.id}/view"
                                                    class="btn btn-danger btn-sm px-3 fw-bold">
                                                    <i class="bi bi-eye-fill ms-2"></i> VIEW
                                                </a>
                                                <a href="/animes/${anime.id}/edit"
                                                    class="btn btn-danger btn-sm px-3 fw-bold">
                                                    <i class="bi bi-pencil-fill me-1"></i> EDIT
                                                </a>
                                                <a href="/animes/${anime.id}/delete"
                                                    class="btn btn-danger btn-sm px-3 fw-bold">
                                                    <i class="bi bi-trash-fill ms-2"></i> DELETE
                                                </a>
                                            </td>
                                        </tr>
                                    </#list>
                                </tbody>

                            </table>
                        </div>

                    </div>

                   


                    <div class="card-content" id="reviews">
                        <h5 class="fw-bold mb-3 text-uppercase">REVIEWS</h5>
                        <p>Conteúdo de reviews aqui...</p>
                    </div>


                    <div class="card-content" id="analytics">
                        <h5 class="fw-bold mb-3 text-uppercase">ANALYTICS</h5>
                        <p>Conteúdo de analytics aqui...</p>
                    </div>


                    <div class="card-content" id="settings">
                        <h5 class="fw-bold mb-3 text-uppercase">SETTINGS</h5>
                        <p>Conteúdo de settings aqui...</p>
                    </div>


                    <div class="card-content" id="logout">
                        <h5 class="fw-bold mb-3 text-uppercase">LOGOUT</h5>
                        <p>Conteúdo de logout aqui...</p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 ps-2 pe-4">
                <div class="stats-card">
                    <h5 class="fw-bold mb-4 text-uppercase">QUICK STATS</h5>
                    <p class="mb-2">
                        Total Anime
                        <span class="float-end fw-bold text-accent">5,231</span>
                    </p>
                    <p class="mb-2">
                        Total Users <span class="float-end fw-bold">150,890</span>
                    </p>
                    <p class="mb-0">
                        New Reviews Today
                        <span class="float-end fw-bold text-accent">457</span>
                    </p>
                </div>

                <div class="activity-card">
                    <h5 class="fw-bold mb-4 text-uppercase">RECENT ACTIVITY</h5>
                    <p class="text-secondary mb-3" style="font-size: 0.9rem">
                        Admin edited <span class="text-accent">"Jujutsu Kaisen"</span>
                    </p>
                    <p class="text-secondary mb-3" style="font-size: 0.9rem">
                        • User <span class="text-accent">"admin121"</span> added
                        <span class="text-accent">"Jujutsu Kaisen"</span>
                    </p>
                    <p class="text-secondary mb-3" style="font-size: 0.9rem">
                        • New user registered:
                        <span class="text-accent">"animefan99"</span> <br /><span class="text-muted"
                            style="font-size: 0.7rem">(2014-AB) 2H15</span>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>

        const sidebarItems = document.querySelectorAll('.sidebar-item');
        const cardContents = document.querySelectorAll('.card-content');

        function showSection(targetId) {
            cardContents.forEach(content => {
                content.style.display = (content.id === targetId) ? 'block' : 'none';
            });

            // Atualiza a classe ativa na sidebar
            sidebarItems.forEach(item => {
                item.classList.toggle('active', item.dataset.target === targetId);
            });
        }

        // Inicial: mostrar Animes
        showSection('animes');

        // Evento de clique
        sidebarItems.forEach(item => {
            item.addEventListener('click', () => {
                if (item.dataset.target === 'logout') {
                    // dispara o formulário de logout
                    document.getElementById('logoutForm').submit();
                } else {
                    showSection(item.dataset.target);
                }
            });
        });

        const searchInput = document.getElementById('animeSearch');
        searchInput.addEventListener('keyup', function () {
            const filter = searchInput.value.toLowerCase();
            const rows = document.querySelectorAll('#animes tbody tr');
            rows.forEach(row => {
                const title = row.cells[1].textContent.toLowerCase();
                row.style.display = title.includes(filter) ? '' : 'none';
            });
        });

    </script>
</body>

</html>