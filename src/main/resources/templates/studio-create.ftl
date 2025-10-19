<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Studio - Higanbana Admin</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/dashboard.css" />
</head>

<body>
   <#include "partials/navbar.ftl">

    <div class="container mt-5 mb-5">
        <div class="card shadow-lg p-4 border-0 rounded-4">
            <h4 class="fw-bold mb-4 text-uppercase text-red">
                <i class="bi bi-building me-2"></i> Create New Studio
            </h4>

            <form action="/studios/create" method="post">
                <div class="row g-3">
                    <div class="col-12">
                        <label for="studioName" class="form-label fw-bold">
                            <i class="bi bi-pencil-square me-1"></i> Studio Name
                        </label>
                        <input type="text" class="form-control" id="studioName" name="name"
                            placeholder="e.g., MAPPA, Ufotable, Studio Ghibli" required />
                    </div>
                </div>

                <div class="mt-5 d-flex justify-content-between">
                    <a href="/dashboard" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                        <i class="bi bi-arrow-left me-1"></i> Back
                    </a>
                    <button type="submit" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                        <i class="bi bi-plus-circle-fill me-1"></i> Create Studio
                    </button>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>