<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <title>Swiper demo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600;700;800&amp;display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <!-- Demo styles -->
    <script src="https://www.amcharts.com/lib/3/amcharts.js?x"></script>
        <script src="https://www.amcharts.com/lib/3/serial.js?x"></script>
        <script src="https://www.amcharts.com/lib/3/themes/dark.js"></script>
        <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  </head>
  <body>
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide">
          <div class="banner">
            <span class="img1"></span>
          </div>
          <div class="text">
            <h1>Casos notificados de arboviroses aumentam 102,51% na Paraíba</h1>
          </div>
        </div>
        <div class="swiper-slide">
          <div class="banner">
            <span class="img2"></span>
          </div>
          <div class="text">
            <h1>Em decisão histórica, OMS aprova vacinação contra malária</h1>
          </div>
        </div>
        <div class="swiper-slide">
          <div class="banner">
            <span class="img3"></span>
          </div>
          <div class="text">
            <h1>Organização alerta sobre aumento da malária no Brasil</h1>
          </div>
        </div>
        <div class="swiper-slide">
          <div class="banner">
            <span class="img4"></span>
          </div>
          <div class="text">
            <h1>Alagoas tem 4 municípios em risco de surto de dengue</h1>
          </div>
        </div>
      </div>
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-pagination"></div>
    </div>
<!-- Swiper JS -->
    <div class="header">
      <div class="content-header">
        <div class="logo">
          <img src="https://www.environmentalscience.bayer.com.br/assets/img/logo-white.svg" alt="Logo Bayer">
        </div>
        <div class="header-menu">
          <div class="text-header">
            <a href="#">
              Prevenção
            </a>
          </div>
          <div class="text-header">
            <a href="#sintomas">
              Sintomas
            </a>
          </div>
          <div class="text-header">
            <a href="">Fale conosco</a>
          </div>
          <div class="text-header">
            <a href="">Blog</a>
          </div>
        </div>
        <div class="icons">
          <div class="user">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
            </svg>
          </div>
          <div class="search">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
              <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
            </svg>
          </div>
        </div>
      </div>
    </div>
    <br>
    <div id="chartdiv"></div>	
    <script>
        var swiper = new Swiper(".mySwiper", {
  centeredSlides: true,
   autoplay: {
    delay: 4000,
     disableOnInteraction: false,
   },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  loop: true,
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});

// window.addEventListener("scroll", function(){
//   var header = document.querySelector('.header');
//   var sticky = header.offsetTop
//   if (window.pageYOffset > 300) {
//       header.classList.add("sticky");
//     }else {
//       header.classList.remove("sticky");
//     }
//     console.log(window.scrollY)
// })

var chartData = [
  {
      "date": "2012-01-01",
      "Zika": 54,
      "Malaria": 48,
      "Dengue": 60,
      "townName1": "Norte",
      "townName2": "Nordeste",
      "townName3": "Centro-Oeste",
      "townName4": "Sul",
      "townName5": "Sudeste",
      "townSize": 14,
      "Norte": 30,
      "Nordeste": 27,
      "Centro-oeste": 32,
      "Sul": 39,
      "Sudeste": 34
  },
  {
      "date": "2012-01-02",
      "Zika": 51,
      "Malaria": 43,
      "Dengue": 58,
      "townName": "Norte",
      "townName2": "Nordeste",
      "townName3": "Centro-Oeste",
      "townName4": "Sul",
      "townName5": "Sudeste",
      "townSize": 14,
      "Norte": 29,
      "Nordeste": 32,
      "Centro-oeste": 31,
      "Sul": 23,
      "Sudeste": 37
  },
  {
      "date": "2012-01-03",
      "Zika": 45,
      "Malaria": 77,
      "Dengue": 63,
      "townName": "Norte",
      "townName2": "Nordeste",
      "townName3": "Centro-Oeste",
      "townName4": "Sul",
      "townName5": "Sudeste",
      "townSize": 14,
      "Norte": 32,
      "Nordeste": 25,
      "Centro-oeste": 41,
      "Sul": 47,
      "Sudeste": 40 
  },
  {
      "date": "2012-01-04",
  },
];
var chart = AmCharts.makeChart("chartdiv", {
type: "serial",
theme: "dark",
dataDateFormat: "YYYY-MM-DD",
dataProvider: chartData,

addClassNames: true,
startDengue: 1,
color: "#FFFFFF",
marginLeft: 0,

categoryField: "date",
categoryAxis: {
  parseDates: true,
  minPeriod: "DD",
  autoGridCount: false,
  gridCount: 50,
  gridAlpha: 0.1,
  gridColor: "#FFFFFF",
  axisColor: "#555555",
  dateFormats: [{
      period: 'DD',
      format: 'DD'
  }, {
      period: 'WW',
      format: 'MMM DD'
  }, {
      period: 'MM',
      format: 'MMM'
  }, {
      period: 'YYYY',
      format: 'YYYY'
  }]
},

valueAxes: [{
  id: "a1",
  title: "Casos",
  gridAlpha: 0,
  axisAlpha: 0
},{
  id: "a2",
  position: "right",
  gridAlpha: 0,
  axisAlpha: 0,
  labelsEnabled: false
},{
  id: "a3",
  title: "Casos",
  position: "right",
  gridAlpha: 0,
  axisAlpha: 0,
  inside: true,
  Dengue: "mm",
  DengueUnits: {
      DD: "d. ",
      hh: "h ",
      mm: "min",
      ss: ""
  }
}],
graphs: [{
  id: "g1",
  valueField:  "Norte",
  title:  "Norte",
  type:  "column",
  fillAlphas:  0.4,
  valueAxis:  "a1",
  balloonText:  "[[value]] registros",
  legendValueText:  "[[value]] mi",
  legendPeriodValueText:  "total: [[value.sum]] mi",
  lineColor:  "#0d3650",
  alphaField:  "alpha",
  labelText: "[[townName1]]",
},{
  id: "g4",
  valueField:  "Nordeste",
  title:  "Nordeste",
  type:  "column",
  fillAlphas:  0.4,
  valueAxis:  "a1",
  balloonText:  "[[value]] registros",
  legendValueText:  "[[value]]",
  legendPeriodValueText:  "total: [[value.sum]] mi",
  lineColor:  "#e83d5c",
  alphaField:  "alpha",
  labelText: "[[townName2]]",
},{
  id: "g5",
  valueField:  "Centro-oeste",
  title:  "Centro-oeste",
  type:  "column",
  fillAlphas:  0.4,
  valueAxis:  "a1",
  balloonText:  "[[value]] registros",
  legendValueText:  "[[value]] mi",
  legendPeriodValueText:  "total: [[value.sum]] mi",
  lineColor:  "#5b4d66",
  alphaField:  "alpha",
  labelText: "[[townName3]]",
},{
  id: "g6",
  valueField:  "Sul",
  title:  "Sul",
  type:  "column",
  fillAlphas:  0.4,
  valueAxis:  "a1",
  balloonText:  "[[value]] registros",
  legendValueText:  "[[value]] mi",
  legendPeriodValueText:  "total: [[value.sum]] mi",
  lineColor:  "#00bcff",
  alphaField:  "alpha",
  labelText: "[[townName4]]",
},{
  id: "g7",
  valueField:  "Sudeste",
  title:  "Sudeste",
  type:  "column",
  fillAlphas:  0.4,
  valueAxis:  "a1",
  balloonText:  "[[value]] registros",
  legendValueText:  "[[value]] mi",
  legendPeriodValueText:  "total: [[value.sum]] mi",
  lineColor:  "#F3e500",
  alphaField:  "alpha",
  labelText: "[[townName5]]",
},{
  id: "g2",
  title: "Zika",
  valueField: "Zika",
  type: "line",
  valueAxis: "a3",
  lineColor: "#ffff",
  balloonText: "[[value]]",
  lineThickness: 1,
  legendValueText: "[[value]]",
  bullet: "square",
  bulletBorderColor: "#00000",
  bulletBorderThickness: 1,
  bulletBorderAlpha: 1,
  dashLengthField: "dashLength",
  animationPlayed: true
},{
  id: "g3",
  title: "Dengue",
  valueField: "Dengue",
  type: "line",
  valueAxis: "a3",
  lineColor: "#ffff",
  balloonText: "[[value]]",
  lineThickness: 1,
  legendValueText: "[[value]]",
  bullet: "square",
  bulletBorderColor: "#ffff",
  bulletBorderThickness: 1,
  bulletBorderAlpha: 1,
  dashLengthField: "dashLength",
  animationPlayed: true
},{
  id: "g8",
  title: "Malaria",
  valueField: "Malaria",
  type: "line",
  valueAxis: "a3",
  lineColor: "#ffff",
  balloonText: "[[value]]",
  lineThickness: 1,
  legendValueText: "[[value]]",
  bullet: "square",
  bulletBorderColor: "#ffff",
  bulletBorderThickness: 1,
  bulletBorderAlpha: 1,
  dashLengthField: "dashLength",
  animationPlayed: true
}],

chartCursor: {
  zoomable: false,
  categoryBalloonDateFormat: "DD",
  cursorAlpha: 0,
  valueBalloonsEnabled: false
},
legend: {
  bulletType: "round",
  equalWidths: false,
  valueWidth: 120,
  useGraphSettings: true,
  color: "#FFFFFF"
}
});
    </script>
  </body>
</html>