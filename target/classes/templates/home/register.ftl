<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Higanbana - Register</title>
    <link rel="icon" type="image/png" href="/img/tokyoFlower.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/login.css" />
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;600&display=swap" rel="stylesheet">
</head>

<body>
    <section class="h-100">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-xl-10">
                    <div class="card rounded-4 text-white">
                        <div class="row g-0">

                            <div class="col-lg-6">
                                <div class="card-body p-0 mx-md-4">
                                    <div class="text-center mb-4">
                                        <img src="/img/tokyoFlower.png" alt="Higanbana Logo" class="logo" />
                                        <h4 class="mt-3 mb-5 pb-1">
                                            Create your <strong>Higanbana</strong> account
                                        </h4>
                                    </div>

                                    <div id="login-error" class="alert alert-danger d-none" role="alert"></div>


                                    <form id="register-form" method="POST" action="/register">
                                        <div class="mb-4">
                                            <label for="username" class="form-label text-white">Username</label>
                                            <input type="text" name="username" id="username"
                                                class="form-control bg-transparent text-white border-bottom border-white rounded-0"
                                                placeholder="Your username" required />
                                        </div>

                                        <div class="mb-4">
                                            <label for="email" class="form-label text-white">E-mail</label>
                                            <input type="email" name="email" id="email"
                                                class="form-control bg-transparent text-white border-bottom border-white rounded-0"
                                                placeholder="E-mail" required />
                                        </div>

                                        <div class="mb-4">
                                            <label for="password" class="form-label text-white">Password</label>
                                            <input type="password" name="password" id="password"
                                                class="form-control bg-transparent text-white border-bottom border-white rounded-0"
                                                placeholder="Password" required />
                                        </div>

                                        <div class="text-center pt-1 mb-5 pb-1">
                                            <button type="submit" class="btn btn-danger btn-block fa-lg mb-3">
                                                Register
                                            </button>
                                        </div>

                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                            <p class="mb-0 text-white">Already have an account?</p>
                                            <a href="/login" class="btn btn-danger">Login</a>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div
                                class="col-lg-6 d-none d-lg-flex justify-content-center align-items-center gradient-custom-2">
                                <p class="higanbana-text text-white display-1">ヒガンバナ</p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
   <script>
  </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
    <script src="/js/login.js"></script>
</body>

</html>