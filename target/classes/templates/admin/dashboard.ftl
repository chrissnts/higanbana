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
    <#include "../partials/navbar.ftl">

    <div class="container-fluid pt-3">
        <div class="row">
            <div class="col-md-2">
                <div class="sidebar-menu d-flex justify-content-center flex-column text-white">
                    <div class="sidebar-item" data-target="users"><i class="bi bi-people-fill me-2"></i> Users</div>
                    <div class="sidebar-item" data-target="animes"><i class="bi bi-film me-2"></i> Animes</div>
                    <div class="sidebar-item" data-target="studios"><i class="bi bi-building me-2"></i> Studios</div>
                    <div class="sidebar-item" data-target="genres"><i class="bi bi-tags-fill me-2"></i>Genres</div>
                    <div class="sidebar-item" data-target="reviews"><i class="bi bi-chat-dots-fill me-2"></i> Reviews
                    </div>
                    <div class="sidebar-item" data-target="analytics"><i class="bi bi-bar-chart-fill me-2"></i>
                        Analytics</div>
                    <div class="sidebar-item" data-target="settings"><i class="bi bi-gear-fill me-2"></i> Settings</div>
                    <div class="sidebar-item" data-target="logout"><i class="bi bi-box-arrow-right me-2"></i> Logout
                    </div>
                </div>
            </div>

            <div class="col-md-7 ps-4 pe-2">
                <div class="main-card">


                    <div class="card-content" id="users">
                        <h5 class="fw-bold mb-3 text-uppercase">USER MANAGEMENT</h5>
                        <div class="mb-3"><input type="text" id="userSearch" class="form-control" placeholder="Search">
                        </div>
                        <div class="table-responsive">
                            <table class="table align-middle mb-0 table-hover">
                                <thead class="text-white">
                                    <tr>
                                        <th>ID</th>
                                        <th>User Name</th>
                                        <th>E-mail</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#list users as user>
                                        <tr class="${(user_index % 2 == 0)?then('table-row-dark', 'table-row-light')}">
                                            <td>${user.id}</td>
                                            <td class="fw-bold">${user.userName}</td>
                                            <td>${user.email}</td>
                                            <td class="d-flex gap-2">
                                                <a href="/users/${user.id}/view"
                                                    class="btn btn-danger btn-sm px-3 fw-bold">
                                                    <iclass="bi bi-eye-fill ms-2"></i> VIEW
                                                </a>
                                                <a href="/users/${user.id}/edit"
                                                    class="btn btn-danger btn-sm px-3 fw-bold"><i
                                                        class="bi bi-pencil-fill me-1"></i> EDIT</a>
                                                <form action="/users/${user.id}/delete" method="post" onsubmit="return confirm('Are you sure you want to delete?');"
                                                    style="display:inline;">
                                                    <button type="submit" class="btn btn-danger btn-sm px-3 fw-bold">
                                                        <i class="bi bi-trash-fill me-1"></i> DELETE
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>


                    <div class="card-content" id="animes">
                        <h5 class="fw-bold mb-3 text-uppercase">ANIME MANAGEMENT</h5>
                        <a class="btn btn-danger mb-4 fw-bold" href="/animes/create">+ ADD NEW ANIME</a>
                        <div class="mb-3"><input type="text" id="animeSearch" class="form-control" placeholder="Search">
                        </div>
                        <div class="table-responsive">
                            <table class="table align-middle mb-0 table-hover">
                                <thead class="text-white">
                                    <tr>
                                        <th>ID</th>
                                        <th>Title</th>
                                        <th>Episodes</th>
                                        <th>Average Rating</th>
                                        <th>Actions</th>
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
                                                    class="btn btn-danger btn-sm px-3 fw-bold"><i
                                                        class="bi bi-eye-fill ms-2"></i> VIEW</a>
                                                <a href="/animes/${anime.id}/edit"
                                                    class="btn btn-danger btn-sm px-3 fw-bold"><i
                                                        class="bi bi-pencil-fill me-1"></i> EDIT</a>
                                                <form action="/animes/${anime.id}/delete" method="post" onsubmit="return confirm('Are you sure you want to delete?');"
                                                    style="display:inline;">
                                                    <button type="submit" class="btn btn-danger btn-sm px-3 fw-bold">
                                                        <i class="bi bi-trash-fill me-1"></i> DELETE
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="card-content" id="studios">
                        <h5 class="fw-bold mb-3 text-uppercase">STUDIO MANAGEMENT</h5>
                        <a class="btn btn-danger mb-4 fw-bold" href="/studios/create">+ ADD NEW STUDIO</a>
                        <div class="mb-3"><input type="text" id="studioSearch" class="form-control"
                                placeholder="Search"></div>
                        <div class="table-responsive">
                            <table class="table align-middle mb-0 table-hover">
                                <thead class="text-white">
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#list studios as studio>
                                        <tr
                                            class="${(studio_index % 2 == 0)?then('table-row-dark', 'table-row-light')}">
                                            <td>${studio.id}</td>
                                            <td class="fw-bold">${studio.name}</td>
                                            <td class="d-flex gap-2">
                                                <a href="/studios/${studio.id}/view"
                                                    class="btn btn-danger btn-sm px-3 fw-bold"><i
                                                        class="bi bi-eye-fill ms-2"></i> VIEW</a>
                                                <a href="/studios/${studio.id}/edit"
                                                    class="btn btn-danger btn-sm px-3 fw-bold"><i
                                                        class="bi bi-pencil-fill me-1"></i> EDIT</a>
                                                <form action="/studios/${studio.id}/delete" method="post" onsubmit="return confirm('Are you sure you want to delete?');"
                                                    style="display:inline;">
                                                    <button type="submit" class="btn btn-danger btn-sm px-3 fw-bold">
                                                        <i class="bi bi-trash-fill me-1"></i> DELETE
                                                    </button>
                                                </form>
                                            </td>
                                        </tr>
                                    </#list>

                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="card-content" id="genres">
                        <h5 class="fw-bold mb-3 text-uppercase">GENRES MANAGEMENT</h5>
                        <a class="btn btn-danger mb-4 fw-bold" href="/genres/create">+ ADD NEW GENRE</a>
                        <div class="mb-3"><input type="text" id="genreSearch" class="form-control" placeholder="Search">
                        </div>
                        <div class="table-responsive">
                            <table class="table align-middle mb-0 table-hover">
                                <thead class="text-white">
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#list genres as genre>
                                        <tr class="${(genre_index % 2 == 0)?then('table-row-dark', 'table-row-light')}">
                                            <td>${genre.id}</td>
                                            <td class="fw-bold">${genre.name}</td>
                                            <td class="d-flex gap-2">
                                                <a href="/genres/${genre.id}/view"
                                                    class="btn btn-danger btn-sm px-3 fw-bold">
                                                    <iclass="bi bi-eye-fill ms-2"></i> VIEW
                                                </a>
                                                <a href="/genres/${genre.id}/edit"
                                                    class="btn btn-danger btn-sm px-3 fw-bold"><i
                                                        class="bi bi-pencil-fill me-1"></i> EDIT
                                                </a>
                                                <form action="/genres/${genre.id}/delete" method="post" onsubmit="return confirm('Are you sure you want to delete?');"
                                                    style="display:inline;" >
                                                    <button type="submit" class="btn btn-danger btn-sm px-3 fw-bold">
                                                        <i class="bi bi-trash-fill me-1"></i> DELETE
                                                    </button>
                                                </form>
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
                    <p class="mb-2">Total Anime <span class="float-end fw-bold text-accent">5,231</span></p>
                    <p class="mb-2">Total Users <span class="float-end fw-bold">150,890</span></p>
                    <p class="mb-0">New Reviews Today <span class="float-end fw-bold text-accent">457</span></p>
                </div>

                <div class="activity-card">
                    <h5 class="fw-bold mb-4 text-uppercase">RECENT ACTIVITY</h5>
                    <p class="text-secondary mb-3" style="font-size: 0.9rem">Admin edited <span
                            class="text-accent">"Jujutsu Kaisen"</span></p>
                    <p class="text-secondary mb-3" style="font-size: 0.9rem">• User <span
                            class="text-accent">"admin121"</span> added <span class="text-accent">"Jujutsu
                            Kaisen"</span></p>
                    <p class="text-secondary mb-3" style="font-size: 0.9rem">• New user registered: <span
                            class="text-accent">"animefan99"</span> <br /><span class="text-muted"
                            style="font-size: 0.7rem">(2014-AB) 2H15</span></p>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/js/dashboard.js"></script>
</body>

</html>