<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>View Anime - Higanbana Admin</title>
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
                <i class="bi bi-eye me-2"></i> View Anime
            </h4>

            <div class="row g-4 align-items-start">

                <div class="col-lg-8">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-type me-2"></i> Title</span>
                            <strong>${anime.title! "N/A"}</strong>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-hash me-2"></i> Episodes</span>
                            <strong>${anime.episodesCount! "N/A"}</strong>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-calendar-event me-2"></i> Release Date</span>
                            <strong>
                                <#if anime.releaseDate??>
                                    ${anime.releaseDate}
                                <#else>
                                    N/A
                                </#if>
                            </strong>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-building me-2"></i> Studio</span>
                            <strong>
                                <#if anime.studio??>
                                    ${anime.studio.name! "N/A"}
                                <#else>
                                    N/A
                                </#if>
                            </strong>
                        </li>

                        <!-- Gêneros com scroll -->
                        <li class="list-group-item">
                            <span class="fw-bold d-block mb-2"><i class="bi bi-tags-fill me-2"></i> Genres</span>
                            <div class="scroll-box border rounded p-2" style="max-height: 120px; overflow-y: auto;">
                                <#if anime.genres?? && (anime.genres?size > 0)>
                                    <#list anime.genres as genre>
                                        <div class="d-flex justify-content-between align-items-center mb-1">
                                            <span>${genre.name! "N/A"}</span>
                                        </div>
                                    </#list>
                                <#else>
                                    <p class="text-center m-0">No genres registered.</p>
                                </#if>
                            </div>
                        </li>

                        <li class="list-group-item">
                            <span class="fw-bold"><i class="bi bi-book-half me-2"></i> Synopsis</span>
                            <p class="mb-0 mt-1">${anime.synopsis! "N/A"}</p>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span><i class="bi bi-star-fill me-2"></i> Rating</span>
                            <strong>${anime.rating!?string("0.0")}</strong>
                        </li>
                    </ul>
                </div>


                <div class="col-lg-4 text-center">
                    <label class="form-label fw-bold d-block mb-2"><i class="bi bi-image me-1"></i> Image</label>
                    <#if anime.imageUrl?? && (anime.imageUrl != "")>
                        <img src="${anime.imageUrl}" alt="${anime.title! "Anime Image"}" 
                             class="img-thumbnail rounded-3 border mx-auto d-block" 
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
                <a href="/animes/${anime.id}/edit" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                    <i class="bi bi-pencil-square me-1"></i> Edit Anime
                </a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
