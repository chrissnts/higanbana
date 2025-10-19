<nav class="navbar navbar-expand-lg py-2 px-3">
    <div class="container-fluid">
        <a class="navbar-brand d-flex align-items-center text-white" href="/dashboard">
            <img src="/img/tokyoFlower.png" alt="Logo" class="rounded-circle me-2"
                style="width: 35px; height: 35px" />
            <strong>Higanbana Admin</strong>
        </a>
    </div>
    <div class="collapse navbar-collapse" id="navbarAnime">
                <ul class="navbar-nav ms-auto align-items-center mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link d-flex align-items-center text-white" href="/profile/${admin.id}">
                            <img src="${admin.profileImage}" alt="Avatar" class="rounded-circle me-2" width="35"
                                height="35" />
                            <span class="fw-bold text-uppercase">${admin.userName}</span>
                        </a>
                    </li>
                </ul>
            </div>
</nav>