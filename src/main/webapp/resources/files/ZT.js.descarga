$(document).ready(function ($) {

    setTimeout(function () {
        $('.modal-backdrop').click(function () {
            $('#popUp').modal('hide');
        });
    }, 1000);

    setInterval('equalColsProductos();', 3000);

    $('form').attr('action', document.URL);

    $('.ui-autocomplete-input').focus(function () {
        autocompleteRezise();
    });

    $(".TableList tr:odd").addClass('odd');
    $('#UserMenu *, #Carrito button, #Carrito a, #Carrito .remove, #Carrito buttom').click(function (e) {
        e.stopPropagation();
    });
    $('#Favoritos a').click(function (e) {
        e.stopPropagation();
    });
    $('.Carrito .remove').click(function () {
        RemoveItemFromBasket($(this));
    });
    $('.Carrito .remove2, #Favoritos .remove2').click(function () {

        var Item = $(this).closest('.BasketItem');
        Item.addClass('animated flipOutX').delay(1000).fadeOut();

    });

    GoPayment();
    $('.envioSi').click(function () {
        $('#DatosEnvioWrapper').fadeIn();
    });
    $('.envioNo').click(function () {
        $('#DatosEnvioWrapper').fadeOut();
    });

    SetViewStyle();

    setInterval(function () {
        UpdateNumBasquet();
        UpdateNumFavorites();
    }, 2000);

    ActivatePlugins();
    LoadAndReziseActions();

    setInterval(function () {
        if ($('.rfvNewsLetter').is(':visible')) {
            $('.MessageNewsletter').hide();
        }
    }, 5000);

    // Fix generico si no carga las fuentes
    if ($("[class^=zt-icon-]").css("font-family") != "zt") {
        $("[class^=zt-icon-]").css("font-family", "zt");
    }

    setTimeout(function () {
        if ($("[class^=zt-icon-]").css("font-family") != "zt") {
            $("[class^=zt-icon-]").hide()
        }
    }, 500);

    /*---- PopUp Login ----*/

    if ($(".hfLoginMode").val() == "login") {
        $(".lnkPopUpLogin").css("display", "none");
    }
    else {
        $(".lnkProfileLogin").css("display", "none");
    }

    $(".lnkPopUpLogin").click(function () {
        ShowLoginPopUp($(".hfLoginMode").val());
    });

    if ($('#MyHistoryList .ProductListWrapper .ProductListContent ul li').length >= 1) {
        $('#MyHistoryList').show();
    }

    /*---- *********** ----*/
    //setInterval(function () {
    //    $('.OfferText img:even').each(function () {
    //        var srcOffer = '/Assets/Images/bandas/oferta1.png';
    //        $(this).attr('src', srcOffer);
    //    });
    //},3500);
});



function ImgErrorVideo(source) {
    source.onerror = null;
    source.src = '/Assets/Images/vacio_b.png';
    return true;
}

function GoPayment() {
    $('#MainContent_GoPayment').click(function () {
        $('#ProcesoCompra').fadeIn();
        var Y = $("#ProcesoCompra").offset();
        window.scrollTo(0, parseFloat(Y.top));
    });
}

function ActivatePlugins() {
    $(':radio').radio();
    $(':checkbox').checkbox();
    $('.chosen-select').chosen({ no_results_text: 'Oops, No encontramos de esos!' });
    $('.chosen-select-no-single').chosen({ disable_search_threshold: 10 });
}
function equalColsProductos() {
    $('.ProductListContent').find("li").css("height","auto");
    $('.ProductListContent').find("li").removeAttr("style");
    group = $('.ProductListContent');
    group.each(function () {
        equalHeightProd($(this));
    });
}

function equalColsVerticalMenu() {
    group = $('.dropdown_fullwidth .listMenuRepeater');
    group.each(function () {
        $(this).find("div").equalHeight();
    });
}

function equalHeightProd(group) {
    tallest = 50;
    group.each(function () {
        thisHeight = $(this).find("li").height();
        if (thisHeight > tallest) {
            tallest = thisHeight + 30;
        }
    });
    group.find("li").height(tallest);

    $('.ProductListWrapper .ProductListContent ul li .ImageContainer img:visible').each(function () {
        var img = $(this).attr('src');
        $(this).hide();
        $(this).parent().css('background-image', 'url(' + img + ')');
    })

}

function equalHeight(group) {
    tallest = 50;
    group.each(function () {
        thisHeight = $(this).height();
        if (thisHeight > tallest) {
            tallest = thisHeight;
        }
    });
    group.height(tallest);
}

function selectCategory(element, id) {
    $('#DisplayCategories').text(element);
    $('#MainContent_SearchUserControl_categorySelected').val(id);
}

function selectCompareProductsCategory(element, id) {
    $('#DisplayCategories').text(element);
    $('#MainContent_categorySelected').val(id);
}

function RemoveItemFromBasket(element) {
    // Item
    var Item = $(element).closest('.BasketItem');
    var price = Item.attr('data-price');
    var Id = Item.attr('data-id');
    var amount = Item.attr('data-amount');
    var Itemtotalprice = price * amount;

    // Total
    var Totalprice = $('.BasketTotalPrice').attr('data-totalprice');

    var NewPrice = Totalprice - Itemtotalprice;
    // Asignar y borrar
    $('.ValueTotalPrice').text(NewPrice.toFixed(2));
    $('.BasketTotalPrice').attr('data-totalprice', NewPrice.toFixed(2));
    Item.addClass('animated flipOutX').delay(1000).fadeOut().remove();
    $('*[data-id=' + Id + ']').delay(1000).fadeOut();
    if (NewPrice == 0) {
        $('.BasketEmpty').removeClass('hidden');
        $('.BasketTotalPrice, .BasketActions, .BasketListItems').remove();
    }
}
function UpdateNumBasquet() {

    var countprod = $('.UserOptions .BasketListItems .BasketItem:visible').length + $('.UserOptions .BasketListItems .BasketItemCombo:visible').length;

    if (countprod >= 1) {
        $('.countprod').text(countprod);
        $('.countprod').show();
    } else {
        $('.countprod').hide();
    }
}

function UpdateNumFavorites() {

    var countFav = $('.UserOptions .FavoritosListItems .BasketItem:visible').length;

    if (countFav >= 1) {
        $('.countfav').text(countFav);
        $('.countfav').show();
    } else {
        $('.countfav').hide();
    }
}




function autocompleteRezise() {
    setInterval(function () {
        if ($('.ui-autocomplete').length) {
            $('.ui-autocomplete').css({ 'width': 'inherit' });
            $('.ui-autocomplete').css({ 'width': $('.ui-autocomplete-input').parent().outerWidth(true) });
        }
    }, 800);
}


/*---------------------------------------------------------*/



function LoadImageSlider() {
    $('#glasscase').glassCase({
        'thumbsPosition': 'bottom',
        'nrThumbsPerRow': 6,
        'isOverlayEnabled': false,
        'isDownloadEnabled': false,
        'colorIcons': '#00abc5',
        'colorActiveThumb': '#00abc5',
        'widthDisplay': '390',
        'heightDisplay': '300'
    });
    $(".CarrouselVideo").prettyPhoto({
        overlay_gallery: true, "theme": 'pp_default', social_tools: false
    });
}


function LastColumnList(List, NumCols, AdClass) {

    var NumCols = NumCols ? NumCols : '3';
    var AdClass = AdClass ? AdClass : 'LastColumnList';

    if ($(List).length) {
        $(List).removeClass(AdClass);
        $(List).each(function (index) {
            if ((index % NumCols) == (NumCols - 1)) {
                $(this).addClass(AdClass);
            }
        });
    }
}

function ReLoadScriptUpdatePanel(functionName) {

    Sys.Application.add_load(functionName);

}

function SetViewStyle() {

    $('.ViewListRow').click(function () {
        $(this).closest('.TitleList').parent().parent().parent().parent().removeClass('ListRow');
        $(this).parent().find('i').removeClass('active');
        $(this).addClass('active');
        setTimeout('equalColsProductos();', 1000);
        $('.ViewListBox').show();
        $('.ViewListRow').hide();
        LastColumnList($(this).closest('.ProductList').find('.ProductListContent ul li'), 4, 'LastColumnList');
    });
    $('.ViewListBox').click(function () {
        $(this).closest('.TitleList').parent().parent().parent().parent().addClass('ListRow');
        $(this).parent().find('i').removeClass('active');
        $(this).addClass('active');
        setTimeout('equalColsProductos();', 1000);
        $('.ViewListRow').show();
        $('.ViewListBox').hide();
        LastColumnList($(this).closest('.ProductList').find('.ProductListContent ul li'), 3, 'LastColumnList');
    });

    $('.ViewListRow').hide();
    $('.ViewListBox').show();
}

function LoadAndReziseActions() {

    equalColsProductos();
    autocompleteRezise();

};

var resizeTimer;
$(window).resize(function () {
    clearTimeout(resizeTimer);
    resizeTimer = setTimeout('LoadAndReziseActions();', 100);
});

function maxCharacters(control, maxLenght) {
    var len = control.value.length;
    if (len >= maxLenght) {
        control.value = control.value.substring(0, maxLenght);
    }
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

function deleteNumberKey0(txtId, evt) {
    if ($("#" + txtId).val() == "0") {
        $("#" + txtId).val("1");
    }
}

function getMapsBranches(stockBranches) {
    contentStringCV = "<div class='customap'><h2 class='color-ZT' ><i class='zt-icon-zonatecno'></i><strong>ZonaTecno</strong> </h2><h4><i class='zt-icon-location'></i><strong> Ciudad Vieja</strong><br></h4><br><p>Juncal 1401 esq. Rincon</p><p>Tel: 29161212 </p><p> L a V:09:00 a 18:00</p> </div>";
    contentStringCordon = "<div class='customap'><h2 class='color0' ><i class='zt-icon-zonatecno'></i><strong>ZonaTecno </strong> </h2><h4><i class='zt-icon-location'></i><strong>Cordon</strong><br></h4><br><p>18 de Julio 2201 esq. Beisso</p><p>Tel: 2401 6057 </p><p> L a V:09:00 a 19:00</p> </div>";
    contentStringNH = "<div class='customap'><h2 class='color0' ><i class='zt-icon-zonatecno'></i><strong>ZonaTecno </strong> </h2><h4><i class='zt-icon-location'></i><strong>Nueva Helvecia</strong><br></h4><br><p>Treinta y Tres 1112 esq. Luis Dreyer</p><p>Tel: 45546407 </p><p>L a V:09:00 - 12:00 y 14:00 - 19:00 S: 09:00 a 12:30</p>  </div>";

    var latlng;
    var zoomimp;
    if ((stockBranches.indexOf("NH") > -1 && stockBranches.indexOf("CEN") > -1) || (stockBranches.indexOf("18") > -1 && stockBranches.indexOf("NH") > -1)) {
        latlng = new google.maps.LatLng(-34.5729393, -56.6767829);
        zoomimp = 9;
    }
    else if (stockBranches.indexOf("NH") < 0) {
        latlng = new google.maps.LatLng(-34.9033841, -56.1894865);
        zoomimp = 14;
    }
    else {
        latlng = new google.maps.LatLng(-34.2890629, -57.2300692);
        zoomimp = 14;
    }

    var myOptions = {
        zoom: zoomimp,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);

    if (stockBranches.indexOf("CEN") > -1) {
        var markerCV = new google.maps.Marker({
            position: new google.maps.LatLng(-34.9051913, -56.201501),
            map: map,
            title: 'ZonaTecno Ciudad Vieja'
        });

        var infowindowZTCV = new google.maps.InfoWindow({
            content: contentStringCV
        });

        google.maps.event.addListener(markerCV, 'click', function () {
            infowindowZTCV.open(map, markerCV);
        });
    }

    if (stockBranches.indexOf("18") > -1) {
        var markerCordon = new google.maps.Marker({
            position: new google.maps.LatLng(-34.8987339, -56.1676935),
            map: map,
            title: 'ZonaTecno Cordón'
        });

        var infowindowZTCordon = new google.maps.InfoWindow({
            content: contentStringCordon
        });

        google.maps.event.addListener(markerCordon, 'click', function () {
            infowindowZTCordon.open(map, markerCordon);
        });
    }

    if (stockBranches.indexOf("NH") > -1) {
        var markerNH = new google.maps.Marker({
            position: new google.maps.LatLng(-34.285266, -57.231737),
            map: map,
            title: 'ZonaTecno Nueva Helvecia'
        });
        var infowindowZTNh = new google.maps.InfoWindow({
            content: contentStringNH
        });

        google.maps.event.addListener(markerNH, 'click', function () {
            infowindowZTNh.open(map, markerNH);
        });

    }

}

function CategoryMenuVertical() {
    var ZTM_GlobalCount = 0;
    var ZTM_ColCount = 0;
    var ZTM_MaxCol = 4;
    var ZTM_MaxColxItems = 10;
    var ZTM_RenderHTML = '<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 itemlistMenuRepeater">';
    var List = $('.ZTmenu_vertical');
    var CategoryCount = List.find('.listMenuRepeater').length;

    for (var i = 0; i < CategoryCount; i++) {

        var Count_SubCategory = $('.listMenuRepeater:eq(' + i + ') .itemlistMenuRepeater').length;
        var MaxItemsPerColumn = $('.listMenuRepeater:eq(' + i + ') .itemlistMenuRepeater li').length;

        ZTM_MaxColxItems = Math.ceil(MaxItemsPerColumn / ZTM_MaxCol);

        for (var j = 0; j < Count_SubCategory; j++) {

            var Count_SubCategoryLi = $('.listMenuRepeater:eq(' + i + ') .itemlistMenuRepeater:eq(' + j + ') li').length;

            if (ZTM_GlobalCount >= ZTM_MaxColxItems) {
                ZTM_RenderHTML += '</div><div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 itemlistMenuRepeater">';
                ZTM_GlobalCount = 0;
            }
            ZTM_RenderHTML += $('.listMenuRepeater:eq(' + i + ') .itemlistMenuRepeater:eq(' + j + ')').html();
            ZTM_GlobalCount += Count_SubCategoryLi;

        }

        ZTM_RenderHTML += '</div>';
        ZTM_BannerMenu = $('.listMenuRepeater:eq(' + i + ') .BannerMenu');
        $('.listMenuRepeater:eq(' + i + ')').html(ZTM_RenderHTML).append(ZTM_BannerMenu);
        ZTM_GlobalCount = 0;
        Count_SubCategory = 0;

        ZTM_RenderHTML = '<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 itemlistMenuRepeater">';

    }

}

/* ---------------- Login Sistema ------------------*/

function ShowLoginPopUp(loginMode) {
    $(".pnlPassword").delay(7000).fadeOut(1000);
    $(".dvlLoginError").css("display", "none");
    switch (loginMode) {
        case "login":
            $('#PopUpLogin').modal('hide');
            break;
        case "error":
            $('#registro').modal('show');
            break;
        case "register":
            $('#success').modal('show');
            break;
        case "InvalidData":
            $(".dvlLoginError").css("display", "block");
            $('#PopUpLogin').modal('show');
            $(".hfLoginMode").attr("value", "");
            break;
        default:
            $('#PopUpLogin').modal('show');
            break;
    }
}

/* ---------------- *************** ------------------*/



/* ---------------- Login Facebook ------------------*/

// This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
        // Logged into your app and Facebook.                
        testAPI();
    }
    //else if (response.status === 'not_authorized') {
    //    // The person is logged into Facebook, but not your app.
    //} else {
    //    // The person is not logged into Facebook, so we're not sure if
    //    // they are logged into this app or not.
    //}
}

function checkLoginState() {
    FB.getLoginStatus(function (response) {
        statusChangeCallback(response);
    });
}

window.fbAsyncInit = function () {
    FB.init({
        appId: '583562241755539',
        cookie: true,  // enable cookies to allow the server to access 
        // the session
        xfbml: true,  // parse social plugins on this page
        version: 'v2.1' // use version 2.1
    });
    // Now that we've initialized the JavaScript SDK, we call 
    // FB.getLoginStatus().  This function gets the state of the
    // person visiting this page and can return one of three states to
    // the callback you provide.  They can be:
    //
    // 1. Logged into your app ('connected')
    // 2. Logged into Facebook, but not your app ('not_authorized')
    // 3. Not logged into Facebook and can't tell if they are logged into
    //    your app or not.
    //
    // These three cases are handled in the callback function.
    FB.getLoginStatus(function (response) {
        statusChangeCallback(response);
    });
};

// Load the SDK asynchronously
(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

// Here we run a very simple test of the Graph API after login is
// successful.  See statusChangeCallback() for when this call is made.
function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function (response) {
        //alert(response.email);
        //document.getElementById('status').innerHTML = 'Thanks for logging in, ' + response.name + '!';
        document.cookie = "FacebookCookieEmail=prueba129@gmail.com";
        window.location.reload();
    });
}


/* ---------------- *************** ------------------*/




/* ---------------- Login Google ------------------*/


var OAUTHURL = 'https://accounts.google.com/o/oauth2/auth?';
var VALIDURL = 'https://www.googleapis.com/oauth2/v1/tokeninfo?access_token=';
var SCOPE = 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email';
var CLIENTID = '680827474991-pgsqik5h9cp8a87h5fddvbgvto55n5j8.apps.googleusercontent.com';
var REDIRECT = 'http://localhost:61734/oauth2callback';
var LOGOUT = 'http://accounts.google.com/Logout';
var TYPE = 'token';
var _url = OAUTHURL + 'scope=' + SCOPE + '&client_id=' + CLIENTID + '&redirect_uri=' + REDIRECT + '&response_type=' + TYPE;
var acToken;
var tokenType;
var expiresIn;
var user;
var loggedIn = false;

function login() {
    var win = window.open(_url, "windowname1", 'width=800, height=600');
    var pollTimer = window.setInterval(function () {
        try {
            console.log(win.document.URL);
            if (win.document.URL.indexOf(REDIRECT) != -1) {
                window.clearInterval(pollTimer);
                var url = win.document.URL;
                acToken = gup(url, 'access_token');
                tokenType = gup(url, 'token_type');
                expiresIn = gup(url, 'expires_in');
                win.close();
                validateToken(acToken);
            }
        } catch (e) {
        }
    }, 500);
}

function validateToken(token) {
    $.ajax({
        url: VALIDURL + token,
        data: null,
        success: function (responseText) {
            getUserInfo();
            loggedIn = true;
            window.location.reload();
        },
        dataType: "jsonp"
    });
}

function getUserInfo() {
    $.ajax({
        url: 'https://www.googleapis.com/oauth2/v1/userinfo?access_token=' + acToken,
        data: null,
        success: function (resp) {
            user = resp;
            document.cookie = "GoogleCookieEmail=prueba129@gmail.com";
        },
        dataType: "jsonp"
    });
}

//credits: http://www.netlobo.com/url_query_string_javascript.html
function gup(url, name) {
    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regexS = "[\\#&]" + name + "=([^&#]*)";
    var regex = new RegExp(regexS);
    var results = regex.exec(url);
    if (results == null)
        return "";
    else
        return results[1];
}

function startLogoutPolling() {
    $('#loginText').show();
    loggedIn = false;
}


/* ---------------- *************** ------------------*/