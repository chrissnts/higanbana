<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Higanbana - ${anime.title}</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/favorites.css" />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>
    <#include "../partials/navbaruser.ftl">

        <div class="container mt-4">
            <div class="row">
                <div class="col-md-4 text-center">
                    <#if anime.imageUrl?? && (anime.imageUrl !="" )>
                        <img src="${anime.imageUrl}" alt="${anime.title}" class="img-fluid rounded mb-3"
                            style="max-height: 400px; object-fit: cover" />
                        <#else>
                            <p class="text-muted">No Image</p>
                    </#if>
                </div>

                <div class="col-md-8 text-white">
                    <h2 class="fw-bold">
                        ${anime.title}
                        <small class="text-white-50">(${anime.releaseDate! "N/A"})</small>
                    </h2>
                    <p class="text-white-50">${anime.synopsis}</p>

                    <ul class="list-group list-group-flush bg-transparent">
                        <li class="list-group-item bg-transparent text-white border-0 px-0">
                            <span><i class="bi bi-hash me-2"></i> Episodes: <strong>${anime.episodesCount!
                                    "N/A"}</strong></span>
                        </li>
                        <li class="list-group-item bg-transparent text-white border-0 px-0">
                            <span><i class="bi bi-building me-2"></i> Studio: <strong>
                                    <#if anime.studio??>
                                        ${anime.studio.name! "N/A"}
                                        <#else>
                                            N/A
                                    </#if>
                                </strong></span>
                        </li>
                        <li class="list-group-item bg-transparent text-white border-0 px-0">
                            <span class="fw-bold d-block mb-2"><i class="bi bi-tags-fill me-2"></i> Genres</span>
                            <div class="scroll-box border rounded p-2" style="max-height: 120px; overflow-y: auto;">
                                <#if anime.genres?? && (anime.genres?size> 0)>
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
                        <li class="list-group-item bg-transparent text-white border-0 px-0">
                            <span><i class="bi bi-star-fill me-2"></i> Average Rating:
                                <strong>${anime.averageRating?string["0.0"]}</strong></span>
                        </li>
                    </ul>

                    <div class="d-flex gap-2 mb-3">
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#logModal">
                            + LOG
                        </button>
                        <form action="/watchlist/add/${anime.id}" method="post" class="d-inline">
                            <button type="submit" class="btn btn-danger">+ Watchlist</button>
                        </form>
                    </div>

                    <h5>Friends' Reviews:</h5>
                    <div class="list-group mb-4">
                        <!-- Review 1 -->
                        <div class="list-group-item bg-anime text-white">
                            <p class="mb-1"><strong>Amigo1</strong></p>
                            <div class="mb-1">
                                <span style="color: gold">★</span>
                                <span style="color: gold">★</span>
                                <span style="color: gold">★</span>
                                <span style="color: gray">★</span>
                                <span style="color: gray">★</span>
                            </div>
                            <p>Gostei bastante deste anime!</p>
                        </div>

                        <!-- Review 2 -->
                        <div class="list-group-item bg-anime text-white">
                            <p class="mb-1"><strong>Amigo2</strong></p>
                            <div class="mb-1">
                                <span style="color: gold">★</span>
                                <span style="color: gold">★</span>
                                <span style="color: gold">★</span>
                                <span style="color: gold">★</span>
                                <span style="color: gray">★</span>
                            </div>
                            <p>Visual incrível e história envolvente.</p>
                        </div>

                        <!-- Review 3 -->
                        <div class="list-group-item bg-anime text-white">
                            <p class="mb-1"><strong>Amigo3</strong></p>
                            <div class="mb-1">
                                <span style="color: gold">★</span>
                                <span style="color: gold">★</span>
                                <span style="color: gray">★</span>
                                <span style="color: gray">★</span>
                                <span style="color: gray">★</span>
                            </div>
                            <p>Não foi meu favorito, mas vale a pena assistir.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="logModal" tabindex="-1" aria-labelledby="logModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content bg-dark text-white">
                    <div class="modal-header border-0">
                        <h5 class="modal-title" id="logModalLabel">Log Anime</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                    </div>
                    <div class="modal-body">


                        <div class="mb-3">
                            <label class="form-label">Rate:</label>
                            <div class="star-rating d-flex gap-1">
                                <input type="radio" id="star5" name="rating" value="5" />
                                <label for="star5" title="5 stars">★</label>

                                <input type="radio" id="star4" name="rating" value="4" />
                                <label for="star4" title="4 stars">★</label>

                                <input type="radio" id="star3" name="rating" value="3" />
                                <label for="star3" title="3 stars">★</label>

                                <input type="radio" id="star2" name="rating" value="2" />
                                <label for="star2" title="2 stars">★</label>

                                <input type="radio" id="star1" name="rating" value="1" />
                                <label for="star1" title="1 star">★</label>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="reviewText" class="form-label">Your review:</label>
                            <textarea class="form-control" id="reviewText" name="review" rows="4"
                                placeholder="Write your review here...">${userReview!""}</textarea>
                        </div>
                        <form action="/log/submit/${anime.id}" method="post" class="mb-2">
                            <input type="hidden" name="rating" value="" id="ratingHidden" />
                            <input type="hidden" name="review" value="" id="reviewHidden" />
                            <button type="submit" class="btn btn-success w-100">
                                Submit Log
                            </button>
                        </form>
                        <form action="/favorites/add/${anime.id}" method="post" class="mb-2">
                            <button type="submit" class="btn btn-danger w-100">
                                ❤ Favorite
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="/js/viewAnime.js"></script>
</body>

</html>