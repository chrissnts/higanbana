<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Higanbana - All Animes</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/favorites.css" /> <!-- reaproveitando o estilo -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>

    <#include "../partials/navbaruser.ftl">

        <div class="container mt-4">
            <div class="row row-cols-2 row-cols-sm-3 row-cols-md-4 row-cols-lg-5 g-4 justify-content-center">
                <#list animes as anime>
                    <div class="col">
                        <a href="/anime/${anime.id}" class="text-decoration-none">
                            <div class="card bg-anime text-white border-0 h-100 "
                                style="cursor:pointer; max-width:200px; margin-top: 75px;">

                                <div class="m-2" style="height:200px; overflow:hidden;">
                                    <img src="${anime.imageUrl}" alt="${anime.title}" class="img-fluid w-100 h-100" style="object-fit:cover;">
                                </div>

                                <div class="card-body text-center d-flex flex-column justify-content-between" style="height:80px;">

                                    <h6 class="card-title text-white fw-bold mb-1"
                                        style="font-size:0.9rem; height:2.4em; line-height:1.2em; overflow:hidden; text-overflow:ellipsis;">
                                        ${anime.title}
                                    </h6>
                                    <p class="text-white-50 mb-0" style="font-size:0.85rem;">
                                        Rating: ${anime.averageRating?string["0.0"]}
                                    </p>
                                </div>
                            </div>
                        </a>
                    </div>
                </#list>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>