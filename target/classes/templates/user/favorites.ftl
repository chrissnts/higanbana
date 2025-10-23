<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Higabana - Home</title>
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
      <h2 class="text-center">Favorites</h2>

      <ul class="nav nav-tabs justify-content-center mt-4" id="favoritesTabs" role="tablist">
        <li class="nav-item" role="presentation">
          <button class="nav-link active btn-color text-light" id="animes-tab" data-bs-toggle="tab"
            data-bs-target="#animes" type="button" role="tab">Animes</button>
        </li>
        <li class="nav-item" role="presentation">
          <button class="nav-link btn-color text-light" id="reviews-tab" data-bs-toggle="tab" data-bs-target="#reviews"
            type="button" role="tab">Reviews</button>
        </li>
        <li class="nav-item" role="presentation">
          <button class="nav-link btn-color text-light" id="lists-tab" data-bs-toggle="tab" data-bs-target="#lists"
            type="button" role="tab">Lists</button>
        </li>
      </ul>

      <div class="tab-content mt-4" id="favoritesTabsContent">

        <div class="tab-pane fade show active" id="animes" role="tabpanel">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-5 g-4 justify-content-center">
            <#list favorites as anime>
              <div class="col">
                <a href="/anime/${anime.id}" class="text-decoration-none">
                  <div class="card bg-anime text-white border-0 h-100" style="cursor:pointer; max-width:200px;">
                    <div class="m-2" style="height:200px; overflow:hidden;">
                      <img src="${anime.imageUrl}" alt="${anime.title}" class="img-fluid w-100 h-100"
                        style="object-fit:cover;">
                    </div>
                    <div class="card-body text-center d-flex flex-column justify-content-between" style="height:80px;">
                      <h6 class="card-title text-white fw-bold mb-1"
                        style="font-size:0.9rem; height:2.4em; line-height:1.2em; overflow:hidden; text-overflow:ellipsis;">
                        ${anime.title}
                      </h6>
                      <div class="stars mb-1" style="font-size:0.85rem;">
                        <#assign rating=userRatings[anime.id]!0>
                            <#list 1..5 as i>
                              <#if i <=rating>
                                ⭐
                                <#elseif i - rating==0.5>
                                  ⯨
                                  <#else>
                                    ☆
                              </#if>
                            </#list>
                      </div>
                      <div class="text-danger" style="font-size: 1rem;">❤</div>
                    </div>
                  </div>
                </a>
              </div>
            </#list>
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