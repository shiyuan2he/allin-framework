<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>similar shopping</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/template/style.css" />
    <!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/template/iecss.css" />
    <![endif]-->
    <script type="text/javascript" src="<%=basePath%>js/template/boxOver.js"></script>
</head>
<body>

<div id="main_container">
    <div class="top_bar">
        <div class="top_search">
            <div class="search_text"><a href="#">Advanced Search</a></div>
            <input type="text" class="search_input" name="search" />
            <input type="image" src="<%=basePath%>images/template/search.gif" class="search_bt"/>
        </div>

        <div class="languages">
            <div class="lang_text">Languages:</div>
            <a href="#" class="lang"><img src="<%=basePath%>images/template/en.gif" alt="" title="" border="0" /></a>
            <a href="#" class="lang"><img src="<%=basePath%>images/template/de.gif" alt="" title="" border="0" /></a>
        </div>

    </div>
    <div id="header">
        <div id="logo">
            <a href="index.html"><img src="<%=basePath%>images/template/logo.png" alt="" title="" border="0" width="237" height="140" /></a>
        </div>
        <div class="oferte_content">
            <div class="top_divider"><img src="<%=basePath%>images/template/header_divider.png" alt="" title="" width="1" height="164" /></div>
            <div class="oferta">
                <div class="oferta_content">
                    <img src="<%=basePath%>images/template/laptop.png" width="94" height="92" border="0" class="oferta_img" />
                    <div class="oferta_details">
                        <div class="oferta_title">Samsung GX 2004 LM</div>
                        <div class="oferta_text">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                        </div>
                        <a href="details.html" class="details">details</a>
                    </div>
                </div>
                <div class="oferta_pagination">
                    <span class="current">1</span>
                    <a href="#?page=2">2</a>
                    <a href="#?page=3">3</a>
                    <a href="#?page=3">4</a>
                    <a href="#?page=3">5</a>
                </div>
            </div>
            <div class="top_divider"><img src="<%=basePath%>images/template/header_divider.png" alt="" title="" width="1" height="164" /></div>
        </div> <!-- end of oferte_content-->
    </div>
    <div id="main_content">
        <div id="menu_tab">
            <div class="left_menu_corner"></div>
            <ul class="menu">
                <li><a href="index.html" class="nav1">  Home </a></li>
                <li class="divider"></li>
                <li><a href="#" class="nav2">Products</a></li>
                <li class="divider"></li>
                <li><a href="#" class="nav3">Specials</a></li>
                <li class="divider"></li>
                <li><a href="#" class="nav4">My account</a></li>
                <li class="divider"></li>
                <li><a href="#" class="nav4">Sign Up</a></li>
                <li class="divider"></li>
                <li><a href="#" class="nav5">Shipping </a></li>
                <li class="divider"></li>
                <li><a href="contact.html" class="nav6">Contact Us</a></li>
                <li class="divider"></li>
                <li class="currencies">Currencies
                    <select>
                        <option>US Dollar</option>
                        <option>Euro</option>
                    </select>
                </li>
            </ul>
            <div class="right_menu_corner"></div>
        </div><!-- end of menu tab -->
        <div class="crumb_navigation">
            Navigation: <span class="current">Home</span>
        </div>
        <div class="left_content">
            <div class="title_box">Categories</div>
            <ul class="left_menu">
                <li class="odd"><a href="services.html">Processors</a></li>
                <li class="even"><a href="services.html">Motherboards</a></li>
                <li class="odd"><a href="services.html">Desktops</a></li>
                <li class="even"><a href="services.html">Laptops & Notebooks</a></li>
                <li class="odd"><a href="services.html">Processors</a></li>
                <li class="even"><a href="services.html">Motherboards</a></li>
                <li class="odd"><a href="services.html">Processors</a></li>
                <li class="even"><a href="services.html">Motherboards</a></li>
                <li class="odd"><a href="services.html">Desktops</a></li>
                <li class="even"><a href="services.html">Laptops & Notebooks</a></li>
                <li class="odd"><a href="services.html">Processors</a></li>
                <li class="even"><a href="services.html">Motherboards</a></li>
            </ul>
            <div class="title_box">Special Products</div>
            <div class="border_box">
                <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
                <div class="product_img"><a href="details.html"><img src="images/laptop.png" alt="" title="" border="0" /></a></div>
                <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
            </div>
            <div class="title_box">Newsletter</div>
            <div class="border_box">
                <input type="text" name="newsletter" class="newsletter_input" value="your email"/>
                <a href="#" class="join">join</a>
            </div>
            <div class="banner_adds">

                <a href="#"><img src="<%=basePath%>images/template/bann2.jpg" alt="" title="" border="0" /></a>
            </div>
        </div><!-- end of left content -->
        <div class="center_content">
            <div class="center_title_bar">Latest Products</div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/laptop.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Iphone Apple</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/p4.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Samsung Webcam</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/p5.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/laptop.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Iphone Apple</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/p4.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Samsung Webcam</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/p5.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="center_title_bar">Recommended Products</div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/laptop.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Iphone Apple</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/p4.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
            <div class="prod_box">
                <div class="top_prod_box"></div>
                <div class="center_prod_box">
                    <div class="product_title"><a href="details.html">Samsung Webcam</a></div>
                    <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/p5.gif" alt="" title="" border="0" /></a></div>
                    <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
                </div>
                <div class="bottom_prod_box"></div>
                <div class="prod_details_tab">
                    <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/cart.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favs.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/favorites.gif" alt="" title="" border="0" class="left_bt" /></a>
                    <a href="details.html" class="prod_details">details</a>
                </div>
            </div>
        </div><!-- end of center content -->
        <div class="right_content">
            <div class="shopping_cart">
                <div class="cart_title">Shopping cart</div>
                <div class="cart_details">
                    3 items <br />
                    <span class="border_cart"></span>
                    Total: <span class="price">350$</span>
                </div>
                <div class="cart_icon"><a href="#" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="<%=basePath%>images/template/shoppingcart.png" alt="" title="" width="48" height="48" border="0" /></a></div>
            </div>
            <div class="title_box">What’s new</div>
            <div class="border_box">
                <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
                <div class="product_img"><a href="details.html"><img src="<%=basePath%>images/template/p2.gif" alt="" title="" border="0" /></a></div>
                <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
            </div>
            <div class="title_box">Manufacturers</div>
            <ul class="left_menu">
                <li class="odd"><a href="services.html">Sony</a></li>
                <li class="even"><a href="services.html">Samsung</a></li>
                <li class="odd"><a href="services.html">Daewoo</a></li>
                <li class="even"><a href="services.html">LG</a></li>
                <li class="odd"><a href="services.html">Fujitsu Siemens</a></li>
                <li class="even"><a href="services.html">Motorola</a></li>
                <li class="odd"><a href="services.html">Phillips</a></li>
                <li class="even"><a href="services.html">Beko</a></li>
            </ul>
            <div class="banner_adds">
                <a href="#"><img src="<%=basePath%>images/template/bann1.jpg" alt="" title="" border="0" /></a>
            </div>
        </div><!-- end of right content -->
    </div><!-- end of main content -->
    <div class="footer">
        <div class="left_footer">
            <img src="<%=basePath%>images/template/footer_logo.png" alt="" title="" width="170" height="49"/>
        </div>
        <div class="center_footer">
            Template name. All Rights Reserved 2008<br />
            <a href="http://www.cssmoban.com/" title="free templates">cssmoban.com</a><br />
            <img src="<%=basePath%>images/template/payment.gif" alt="" title="" />
        </div>
        <div class="right_footer">
            <a href="index.html">home</a>
            <a href="details.html">about</a>
            <a href="details.html">sitemap</a>
            <a href="details.html">rss</a>
            <a href="contact.html">contact us</a>
        </div>
    </div>
</div>
</body>
</html>