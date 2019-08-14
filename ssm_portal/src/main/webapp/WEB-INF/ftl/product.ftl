<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">
<title>品象书城</title>
<!-- Bootstrap 核心CSS -->
<link rel="stylesheet" href="https://code.z01.com/v4/dist/css/bootstrap.min.css" >
<style>
/* GLOBAL STYLES--------------------------- */
/* Padding below the footer and lighter body text */
body { padding-top: 3rem; padding-bottom: 3rem; color: #5a5a5a; }

/* CUSTOMIZE THE CAROUSEL--------------- */
/* Carousel base class */
.carousel {  margin-bottom: 4rem;}
/* Since positioning the image, we need to help out the caption */
.carousel-caption {  bottom: 3rem;  z-index: 10;}

/* Declare heights because of positioning of img element */
.carousel-item {  height: 32rem;  background-color: #777;}
.carousel-item > img {  position: absolute;  top: 0;  left: 0;  min-width: 100%;  height: 32rem;}

/* MARKETING CONTENT------------------------- */
/* Center align the text within the three columns below the carousel */
.marketing .col-lg-4 {  margin-bottom: 1.5rem;  text-align: center;}
.marketing h2 {  font-weight: 400;}
.marketing .col-lg-4 p {  margin-right: .75rem;  margin-left: .75rem;}

/* Featurettes--------- */
.featurette-divider {  margin: 5rem 0; /* Space out the Bootstrap <hr> more */}

/* Thin out the marketing headings */
.featurette-heading {  font-weight: 300;  line-height: 1;  letter-spacing: -.05rem;}

/* RESPONSIVE CSS------------------------------ */
@media (min-width: 40em) {
/* Bump up size of carousel content */
.carousel-caption p {    margin-bottom: 1.25rem;    font-size: 1.25rem;    line-height: 1.4;  }
.featurette-heading {    font-size: 50px;  }
}

@media (min-width: 62em) {
  .featurette-heading {    margin-top: 7rem;  }
}
</style>
</head>
<body>
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark"> <a class="navbar-brand" href="#">品象</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active"> <a class="nav-link" href="#">主页 <span class="sr-only">(current)</span></a> </li>
        <li class="nav-item"> <a class="nav-link disabled" href="#">小说</a> </li>
        <li class="nav-item"> <a class="nav-link disabled" href="#">悬疑小说</a> </li>
      </ul>
      <form class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">书籍搜索</button>
      </form>
    </div>
  </nav>
</header>
<main role="main">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active"> <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
        <div class="container">
          <div class="carousel-caption text-left">
            <h1>推荐书籍1</h1>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item"> <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
        <div class="container">
          <div class="carousel-caption">
            <h1>推荐书籍2</h1>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item"> <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
        <div class="container">
          <div class="carousel-caption text-right">
            <h1>推荐书籍3</h1>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a> <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span> </a> </div>
  </div>
  <div style="padding-bottom: 45px"><h2 class ="text-center">小说 <span class="badge badge-secondary">悬疑小说</span></h2></div>
  <div class="album py-5 bg-light" style="padding-top: 60px">
      <div class="container">
       
        <div class="row">
          <#list product as p >
          <div class="col-md-4">
            <div class="card mb-4 box-shadow">
              <img class="card-img-top" src="https://images-cn.ssl-images-amazon.com/images/I/51GcwZm-%2ByL.jpg" alt="Card image cap">
              <div class="card-body">
                <h3>${p.name}</h3>
                <small class="text-muted">${p.author}</small>
                <p>---------------</p>
                <p class="card-text">${p.description}</p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">购买</button>
                   
                  </div>
                  <small class="text-muted">${p.price}</small>
                </div>
              </div>
            </div>
          </div>
          </#list>
        </div>
      </div>
    </div>

  <!-- FOOTER -->
  <footer class="container">
    <p class="float-right"><a href="#">Back to top</a></p>
    <p>&copy; 2017 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer>
</main>

<!-- Bootstrap 核心 JavaScript --> 
<script src="https://code.z01.com/js/jquery-3.2.1.slim.min.js" ></script>
<script src="https://code.z01.com/v4/dist/js/popper.min.js"></script>
<script src="https://code.z01.com/v4/dist/js/bootstrap.min.js" ></script>
<!-- 下面是JS图像占位符，不要用于生产环境! -->
<script src="../album/holder.min.js"></script>
</body>
</html>