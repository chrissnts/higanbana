<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Studio - Higanbana Admin</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/styles/dashboard.css">
</head>

<body>
    <#include "../partials/navbar.ftl">

    <div class="container mt-5 mb-5">
        <div class="card shadow-lg border-0 rounded-4 p-4">
            <h4 class="fw-bold mb-4 text-uppercase text-red">
                <i class="bi bi-eye me-2"></i> View Studio
            </h4>

            <ul class="list-group list-group-flush">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <span><i class="bi bi-building me-2"></i> Name</span>
                    <strong>${studio.name! "N/A"}</strong>
                </li>

               <li class="list-group-item">
    <span class="fw-bold d-block mb-2"><i class="bi bi-tv me-2"></i> Animes</span>

    <div class="scroll-box border rounded p-2" style="max-height: 200px; overflow-y: auto;">
        <#if studio.animes?? && (studio.animes?size > 0)>
            <#list studio.animes as anime>
                <div class="d-flex justify-content-between align-items-center mb-1">
                    <span>${anime.title! "N/A"}</span>
                    <small class="text-muted">${anime.episodesCount! "N/A"} eps</small>
                </div>
            </#list>
        <#else>
            <p class="text-center m-0">No anime registered.</p>
        </#if>
    </div>
</li>
            </ul>

            <div class="mt-4 d-flex justify-content-between">
                <a href="/dashboard" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                    <i class="bi bi-arrow-left me-1"></i> Back
                </a>
                <a href="/studios/${studio.id}/edit" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                    <i class="bi bi-pencil-square me-1"></i> Edit Studio
                </a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
