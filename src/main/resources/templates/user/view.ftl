<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>View User - Higanbana Admin</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/dashboard.css" />
</head>

<body>
    <#include "../partials/navbar.ftl">

    <div class="container mt-5 mb-5">
        <div class="card shadow-lg border-0 rounded-4 p-4">
            <h4 class="fw-bold mb-4 text-uppercase text-red">
                <i class="bi bi-eye me-2"></i> View User
            </h4>

            <div class="row g-4 align-items-start">

                <!-- Detalhes do User -->
                <div class="col-lg-8">
                    <ul class="list-group list-group-flush">

                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-person me-2"></i> Username</span>
                            <strong>${user.userName! "N/A"}</strong>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-envelope me-2"></i> Email</span>
                            <strong>${user.email! "N/A"}</strong>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-shield-lock me-2"></i> Role</span>
                            <strong>${user.role! "N/A"}</strong>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <span><i class="bi bi-heart-fill me-2"></i> Favorite Animes</span>
                            <div>
                                <#if user.favoriteAnimes?? && (user.favoriteAnimes?size > 0)>
                                    <#list user.favoriteAnimes as anime>
                                        <span class="badge btn-danger me-1">${anime.title! "N/A"}</span>
                                    </#list>
                                <#else>
                                    N/A
                                </#if>
                            </div>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <span><i class="bi bi-tv me-2"></i> Watched Animes</span>
                            <div>
                                <#if user.watchedAnimes?? && (user.watchedAnimes?size > 0)>
                                    <#list user.watchedAnimes as anime>
                                        <span class="badge btn-secondary me-1">${anime.title! "N/A"}</span>
                                    </#list>
                                <#else>
                                    N/A
                                </#if>
                            </div>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <span><i class="bi bi-bookmark-fill me-2"></i> Watchlist</span>
                            <div>
                                <#if user.watchlistAnime?? && (user.watchlistAnime?size > 0)>
                                    <#list user.watchlistAnime as anime>
                                        <span class="badge btn-warning me-1">${anime.title! "N/A"}</span>
                                    </#list>
                                <#else>
                                    N/A
                                </#if>
                            </div>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <span><i class="bi bi-people-fill me-2"></i> Friends</span>
                            <div>
                                <#if user.friends?? && (user.friends?size > 0)>
                                    <#list user.friends as friend>
                                        <span class="badge btn-info me-1">${friend.userName! "N/A"}</span>
                                    </#list>
                                <#else>
                                    N/A
                                </#if>
                            </div>
                        </li>

                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <span><i class="bi bi-chat-left-text-fill me-2"></i> Comments</span>
                            <div>
                                <#if user.comments?? && (user.comments?size > 0)>
                                    <#list user.comments as comment>
                                        <span class="badge btn-dark me-1">${comment.content! "N/A"}</span>
                                    </#list>
                                <#else>
                                    N/A
                                </#if>
                            </div>
                        </li>

                    </ul>
                </div>

                <!-- Imagem menor -->
                <div class="col-lg-4 text-center">
                    <label class="form-label fw-bold"><i class="bi bi-image me-1"></i> Profile Image</label>
                    <#if user.profileImage?? && (user.profileImage != "")>
                        <img src="${user.profileImage}" alt="${user.userName! "Profile Image"}" 
                             class="img-thumbnail rounded-3 border" 
                             style="max-height: 250px; width: auto;" />
                    <#else>
                        <p class="text-muted mt-2">No Image</p>
                    </#if>
                </div>

            </div>

            <div class="mt-4 d-flex justify-content-between">
                <a href="/dashboard" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                    <i class="bi bi-arrow-left me-1"></i> Back
                </a>
                <a href="/users/${user.id}/edit" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                    <i class="bi bi-pencil-square me-1"></i> Edit User
                </a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
