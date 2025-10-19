<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Anime - Higanbana Admin</title>
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
                <i class="bi bi-folder-plus me-2"></i> Create New Anime
            </h4>

            <form action="/animes/create" method="post" enctype="multipart/form-data">
                <div class="row g-3">

                    <div class="col-md-6">
                        <label for="title" class="form-label fw-bold">
                            <i class="bi bi-type me-1"></i> Title
                        </label>
                        <input type="text" class="form-control" id="title" name="title"
                            placeholder="e.g., Attack on Titan" required />
                    </div>


                    <div class="col-md-2">
                        <label for="episodesCount" class="form-label fw-bold">
                            <i class="bi bi-hash me-1"></i> Episodes
                        </label>
                        <input type="number" class="form-control" id="episodesCount" name="episodesCount" min="1"
                            required />
                    </div>

                    <div class="col-md-2">
                        <label for="releaseDate" class="form-label fw-bold">
                            <i class="bi bi-calendar-event me-1"></i> Release Date
                        </label>
                        <input type="date" class="form-control" id="releaseDate" name="releaseDate" required />
                    </div>
                    
                    
                    <div class="col-md-6">
                        <label for="studio" class="form-label fw-bold">
                            <i class="bi bi-building me-1"></i> Studio
                        </label>
                        <div class="input-group">
                            <select class="form-select" id="studio" name="studioId" required>
                                <option value="">Select Studio</option>
                                <#list studios as studio>
                                    <option value="${studio.id}">${studio.name}</option>
                                </#list>
                            </select>
                            <button type="button" class="btn btn-danger text-white rounded-end-2" data-bs-toggle="modal"
                                data-bs-target="#createStudioModal">
                                <i class="bi bi-plus me-1"></i> New
                            </button>
                        </div>
                    </div>


                    <div class="col-md-6">
                        <label for="genres" class="form-label fw-bold">
                            <i class="bi bi-tags-fill me-1"></i> Genres (Hold Ctrl/Cmd)
                        </label>
                        <div class="input-group">
                             <select class="form-select" id="genres" name="genreIds" multiple required
                                 style="height: 120px;"> <#list genres as genre>
                                     <option value="${genre.id}">${genre.name}</option>
                                 </#list>
                             </select>
                             <button type="button" class="btn btn-danger text-white rounded-end-2 m-2 align-self-start" data-bs-toggle="modal"
                                data-bs-target="#createGenreModal" style="height: 38px;">
                                <i class="bi bi-plus me-1"></i> New
                            </button>
                        </div>
                    </div>
                    
                    
                    <div class="col-12">
                        <hr class="text-red opacity-50 my-4">
                    </div>


                    <div class="col-12">
                        <label for="synopsis" class="form-label fw-bold">
                            <i class="bi bi-book-half me-1"></i> Synopsis
                        </label>
                        <textarea class="form-control" id="synopsis" name="synopsis" rows="4"
                            placeholder="Enter a brief synopsis..." required></textarea>
                    </div>


                    <div class="col-md-6">
                        <label for="imageUrl" class="form-label fw-bold">
                            <i class="bi bi-link-45deg me-1"></i> Image URL
                        </label>
                        <input type="url" class="form-control" id="imageUrl" name="imageUrl"
                            placeholder="https://example.com/anime.jpg" />
                    </div>

                    <div class="col-md-6">
                        <label for="uploadImage" class="form-label fw-bold">
                            <i class="bi bi-cloud-arrow-up-fill me-1"></i> or Upload Image
                        </label>
                        <input class="form-control" type="file" id="uploadImage" name="uploadImage" accept="image/*" />
                    </div>
                </div>

                <div class="mt-5 d-flex justify-content-between">
                    <a href="/dashboard" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                        <i class="bi bi-arrow-left me-1"></i> Back
                    </a>
                    <button type="submit" class="btn btn-danger fw-bold px-5 rounded-3 shadow-sm">
                        <i class="bi bi-save-fill me-1"></i> Save Anime
                    </button>
                </div>
            </form>
        </div>
    </div>


    <div class="modal fade" id="createStudioModal" tabindex="-1" aria-labelledby="createStudioLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/studios/create" method="post" class="modal-content">
                <div class="modal-header btn-danger text-white">
                    <h5 class="modal-title" id="createStudioLabel"><i class="bi bi-plus-circle me-1"></i> Create New Studio</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="studioName" class="form-label">Studio Name</label>
                        <input type="text" class="form-control" id="studioName" name="name"
                            placeholder="e.g., Studio Ghibli" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary rounded-3" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger rounded-3">Create Studio</button>
                    <input type="hidden" id="isActive" name="active" value="true">
                </div>
            </form>
        </div>
    </div>

    <div class="modal fade" id="createGenreModal" tabindex="-1" aria-labelledby="createGenreLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/genres/create" method="post" class="modal-content">
                <div class="modal-header btn-danger text-white">
                    <h5 class="modal-title" id="createGenreLabel"><i class="bi bi-plus-circle me-1"></i> Create New Genre</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="genreName" class="form-label">Genre Name</label>
                        <input type="text" class="form-control" id="genreName" name="name" placeholder="e.g., Action"
                            required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary rounded-3" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger rounded-3">Create Genre</button>
                    <input type="hidden" id="isActive" name="active" value="true">
                </div>
            </form>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>