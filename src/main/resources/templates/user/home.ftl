<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Higanbana - Home</title>
  <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="/styles/home.css" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>
  
  <#include "../partials/navbaruser.ftl">

  <main class="container text-center" style="margin-top: 100px;">
    <h2>Welcome, <a href="/profile" class="text-red fw-bold">${user.userName}</a></h2>
    <p class="text-muted">Look what your friends are watching...</p>
  </main>

  <section class="container mt-5">
    <h5 class="text-white fw-bold">NEW FROM FRIENDS</h5>
    <hr class="text-white" />

    <div class="d-flex flex-row gap-3 overflow-auto px-2 py-3"
      style="background: linear-gradient(to right, #020202, #0a0a0a, #141414); box-shadow: 5px 5px 5px #000;">

      <article class="card text-white p-2 d-flex flex-column align-items-center"
        style="width: 255px; height: 318px; background-color: #2a0404; cursor:pointer;">
        <img src="https://images-cdn.ubuy.co.in/633ff1157e3fbc25557517c8-one-piece-poster-japanese-anime-posters.jpg"
          class="rounded mb-2" style="width: 200px; height: 250px;" />
        <div class="d-flex align-items-center justify-content-center gap-2">
          <img src="https://i.pinimg.com/736x/65/ee/1c/65ee1ca15ea1de2fc176f6c654a503e3.jpg" class="rounded-circle"
            width="30" height="30" />
          <small class="fw-semibold">soldier34 • ⭐⭐⭐⭐⭐</small>
        </div>
        <small class="text-muted">01/06</small>
      </article>
    </div>
  </section>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>