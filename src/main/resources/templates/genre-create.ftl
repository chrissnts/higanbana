<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Genre - Higanbana Admin</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/dashboard.css" />
</head>

<body>
    <nav class="navbar navbar-expand-lg py-2 px-3">
        <div class="container-fluid">
            <a class="navbar-brand d-flex align-items-center text-white" href="/dashboard">
                <img src="/img/tokyoFlower.png" alt="Logo" class="rounded-circle me-2"
                    style="width: 35px; height: 35px" />
                <strong>Higanbana Admin</strong>
            </a>
        </div>
    </nav>

    <div class="container mt-5 mb-5">
        <div class="card shadow-lg p-4 border-0 rounded-4">
            <h4 class="fw-bold mb-4 text-uppercase text-red">
                <i class="bi bi-tags-fill me-2"></i> Create New Genre
            </h4>

            <form action="/genres/create" method="post">
                <div class="row g-3">
                    <div class="col-12">
                        <label for="genreName" class="form-label fw-bold">
                            <i class="bi bi-pencil-square me-1"></i> Genre Name
                        </label>
                        <input type="text" class="form-control" id="genreName" name="name"
                            placeholder="e.g., Action, Fantasy, Slice of Life" required />
                    </div>
                </div>

                <div class="mt-5 d-flex justify-content-between">
                    <a href="/dashboard" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                        <i class="bi bi-arrow-left me-1"></i> Back
                    </a>
                    <button type="submit" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                        <i class="bi bi-plus-circle-fill me-1"></i> Create Genre
                    </button>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>