<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Anime - Higanbana Admin</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/dashboard.css" />
</head>

<body>
    <nav class="navbar navbar-expand-lg py-2 px-3">
        <div class="container-fluid">
            <a class="navbar-brand d-flex align-items-center text-white" href="/dashboard">
                <img src="/img/tokyoFlower.png" alt="Logo" class="rounded-circle me-2"
                    style="width: 35px; height: 35px" />
                <strong>Higanbana</strong>
            </a>
        </div>
    </nav>

    <div class="container mt-5 mb-5">
        <div class="card shadow-lg p-4 border-0">
            <h4 class="fw-bold mb-4 text-uppercase text-red">
                <i class="bi bi-plus-circle me-2"></i> Create New Anime
            </h4>

            <form action="/animes/create" method="post" enctype="multipart/form-data">
                <div class="row g-3">

                    <div class="col-md-6">
                        <label for="title" class="form-label fw-bold">Title</label>
                        <input type="text" class="form-control" id="title" name="title"
                            placeholder="e.g., Attack on Titan" required />
                    </div>


                    <div class="col-md-3">
                        <label for="episodesCount" class="form-label fw-bold">Episodes</label>
                        <input type="number" class="form-control" id="episodesCount" name="episodesCount" min="1"
                            required />
                    </div>


                    <div class="col-md-3">
                        <label for="rating" class="form-label fw-bold">Initial Rating</label>
                        <input type="number" class="form-control" id="rating" name="rating" step="0.1" min="0" max="10"
                            value="0" />
                    </div>


                    <div class="col-md-4">
                        <label for="releaseDate" class="form-label fw-bold">Release Date</label>
                        <input type="date" class="form-control" id="releaseDate" name="releaseDate" required />
                    </div>


                    <div class="col-md-8">
                        <label for="studio" class="form-label fw-bold">Studio</label>
                        <div class="d-flex gap-2">
                            <select class="form-select" id="studio" name="studioId" required>
                                <option value="">Select Studio</option>
                                <#list studios as studio>
                                    <option value="${studio.id}">${studio.name}</option>
                                </#list>
                            </select>
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#createStudioModal">
                                + New Studio
                            </button>
                        </div>
                    </div>



                    <div class="col-12">
                        <label for="genres" class="form-label fw-bold">Genres</label>
                        <div class="d-flex flex-wrap gap-2 align-items-center">
                            <#list genres as genre>
                                <div class="form-check me-2">
                                    <input class="form-check-input" type="checkbox" name="genreIds" value="${genre.id}"
                                        id="genre_${genre.id}" />
                                    <label class="form-check-label" for="genre_${genre.id}">
                                        ${genre.name}
                                    </label>
                                </div>
                            </#list>
                            <button type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                data-bs-target="#createGenreModal">
                                + New Genre
                            </button>
                        </div>
                    </div>




                    <div class="col-12">
                        <label for="synopsis" class="form-label fw-bold">Synopsis</label>
                        <textarea class="form-control" id="synopsis" name="synopsis" rows="4"
                            placeholder="Enter a brief synopsis..." required></textarea>
                    </div>


                    <div class="col-md-6">
                        <label for="imageUrl" class="form-label fw-bold">Image URL</label>
                        <input type="url" class="form-control" id="imageUrl" name="imageUrl"
                            placeholder="https://example.com/anime.jpg" />
                    </div>

                    <div class="col-md-6">
                        <label for="uploadImage" class="form-label fw-bold">or Upload Image</label>
                        <input class="form-control" type="file" id="uploadImage" name="uploadImage" accept="image/*" />
                    </div>
                </div>

                <div class="mt-4 d-flex justify-content-between">
                    <a href="/dashboard" class="btn btn-danger text-white fw-bold px-4">
                        <i class="bi bi-arrow-left me-1"></i> Back
                    </a>
                    <button type="submit" class="btn btn-danger fw-bold px-4">
                        <i class="bi bi-save-fill me-1"></i> Save Anime
                    </button>
                </div>
            </form>
        </div>
    </div>


    <!-- Modal para criar novo studio -->
    <div class="modal fade" id="createStudioModal" tabindex="-1" aria-labelledby="createStudioLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/studios/create" method="post" class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-red" id="createStudioLabel">Create New Studio</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="studioName" class="form-label">Studio Name</label>
                        <input type="text" class="form-control" id="studioName" name="name"
                            placeholder="e.g., Studio Ghibli" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Create Studio</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Modal para criar novo gênero -->
    <div class="modal fade" id="createGenreModal" tabindex="-1" aria-labelledby="createGenreLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/genres/create" method="post" class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-red" id="createGenreLabel">Create New Genre</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="genreName" class="form-label">Genre Name</label>
                        <input type="text" class="form-control" id="genreName" name="name" placeholder="e.g., Action"
                            required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Create Genre</button>
                </div>
            </form>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>