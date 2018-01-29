<div class="sidebar-s -size-fixed-tablet is-hidden-phone">
<form accept-charset="UTF-8" action="/search" class="js-facet-form" data-pjax="" data-view="facetingControls" id="searchFacets" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓"></div>
<div class="search-facet-panel" data-view="searchFacetPanel">

<div class="search-facet-refine">
    Refine your results:
</div>

<input id="term" name="term" type="hidden" value="4">




<div class="search-facet is-hidden--js">
    <div>
        <div class="search-facet-header">
            <h2><i class="e-icon -icon-preview -margin-right"></i><span>View as</span></h2>
        </div>

        <div class="group-select -border-radius-top">
            <label class="is-visually-hidden" for="view">View as</label>
            <select data-pjax="" id="view" name="view"><option selected="selected" value="list">View as: List</option>
                <option value="grid">Grid</option></select>
        </div>

    </div>

    <div>
        <div class="search-facet-header">
            <h2><i class="e-icon -icon-sort -margin-right"></i><span>Sort by</span></h2>
        </div>

        <div class="group-select -border-top-none -border-radius-none">
            <label class="is-visually-hidden" for="sort">Sort by</label>
            <select data-pjax="" id="sort" name="sort"><option selected="selected" value="">Sort by: Best match</option>
                <option value="trending">Trending items</option>
                <option value="sales">Best sellers</option>
                <option value="rating">Best rated</option>
                <option value="date">Newest items</option>
                <option value="price-asc">Price: low to high</option>
                <option value="price-desc">Price: high to low</option></select>
        </div>

    </div>

    <div>
        <div class="search-facet-header">
            <h2><i class="e-icon -icon-calendar -margin-right"></i><span>Added</span></h2>
        </div>

        <div class="group-select -border-top-none -border-radius-bottom">
            <label class="is-visually-hidden" for="date">Added</label>
            <select data-pjax="" id="date" name="date"><option selected="selected" value="">Added: Any date</option>
                <option value="this-year">In the last year - 3,382</option>
                <option value="this-month">In the last month - 324</option>
                <option value="this-week">In the last week - 74</option>
                <option value="this-day">In the last day - 11</option></select>
        </div>

    </div>

</div>

<div class="search-facet">
<div class="search-facet--no-margin">
<div class="js-search-facet-panel__header search-facet-panel__header--start">
    <h2 data-title="Category"><i class="e-icon -icon-folder -margin-right"></i>分类</h2>


    <ul class="search-facet-listing">
        <#list categories as category>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">${category.displayValue}</span>
                <span class="search-facet-result-count">${category.count}</span>
            </div>
        </li>
        </#list>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">WordPress</span>
                <span class="search-facet-result-count">3186</span>
            </div>
        </li>
        <li>

    </ul>

</div>

<div class="js-search-facet-panel__body search-facet-panel__body  is-visually-hidden--js">
    <div class="search-facet-panel__body-inner">
        <button class="js-search-facet-panel__body-close search-facet-panel__body-close">
            <i class="e-icon -icon-cancel">
                <span class="e-icon__alt">Close</span>
            </i>
        </button>
        <div class="search-facet-panel__breadcrumbs-wrapper">
            <div class="search-facet-panel__breadcrumbs-intro">
                <span class="t-body -size-m">Show:</span>
            </div>
            <div class="search-facet-panel__breadcrumbs">
                <nav class="breadcrumbs -line-wrap -color-grey -icon-fill">
                    <a href="/search?category=&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" data-pjax="" rel="nofollow">
                        所有 分类 <span class="breadcrumbs__count">8862</span>
                    </a>
                </nav>
            </div>
        </div>

        <ul class="search-facet-single-select-in-panel">

            <#list categories as category >
                <li class="">
                    <a href="/search?category=site-templates&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(100.0% - 30px);">
                        <div class="search-facet-single-select-panel__title">
                            <div class="search-facet-single-select-panel__title-inner">${category.displayValue}</div>
                        </div>
                    </a>        <div class="search-facet-single-select-panel__count">
                ${category.count}
                </div>
                </li>
            </#list>


            <li class="">
                <a href="/search?category=wordpress&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(98.33% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">WordPress</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                3,186
            </div>
            </li>

            <li class="">
                <a href="/search?category=marketing&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(23.27% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">Marketing</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                754
            </div>
            </li>

            <li class="">
                <a href="/search?category=cms-themes&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(21.2% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">CMS Themes</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                687
            </div>
            </li>

            <li class="">
                <a href="/search?category=psd-templates&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(12.75% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">PSD Templates</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                413
            </div>
            </li>

            <li class="">
                <a href="/search?category=ecommerce&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(12.13% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">eCommerce</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                393
            </div>
            </li>

            <li class="">
                <a href="/search?category=blogging&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(3.55% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">Blogging</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                115
            </div>
            </li>

            <li class="">
                <a href="/search?category=muse-templates&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(1.67% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">Muse Templates</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                54
            </div>
            </li>

            <li class="">
                <a href="/search?category=forums&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.25% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">Forums</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                8
            </div>
            </li>

            <li class="">
                <a href="/search?category=static-site-generators&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.25% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">Static Site Generators</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                8
            </div>
            </li>

            <li class="is-hidden js-collapsible">
                <a href="/search?category=sketch-templates&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.09% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">Sketch Templates</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                3
            </div>
            </li>

            <li class="is-hidden js-collapsible">
                <a href="/search?category=typeengine-themes&amp;date=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.03% - 30px);">
                    <div class="search-facet-single-select-panel__title">
                        <div class="search-facet-single-select-panel__title-inner">TypeEngine Themes</div>
                    </div>
                </a>        <div class="search-facet-single-select-panel__count">
                1
            </div>
            </li>
        </ul>


        <div class="js-search-facet-toggle search-facet-panel-toggle" data-view="facetTogglePanel">
            <a href="#" class="js-search-facet-toggle__link">
        <span>
          <span class="e-icon -icon-preview"></span>
          <span class="search-facet-panel-toggle__remaining">
            显示剩下的两个选项
          </span>
        </span>
                <span>Hide options</span>
            </a>      <div class="search-facet-panel__action">
            <button class="js-search-facet-panel__body-close btn btn--primary btn--dimensions-full-width">确定</button>
        </div>
        </div>

    </div>
</div>
</div>

<div class="search-facet--no-margin">
<div class="js-search-facet-panel__header search-facet-panel__header">
    <h2 data-title="Tags"><i class="e-icon -icon-tag -margin-right"></i>标签（主题）</h2>
    <ul class="search-facet-listing">
     <#list tagsPage.content as tag>
         <li>
             <div class="search-facet-listing__link">
                 <span class="search-facet-listing__label">${tag.tagName}</span>
                 <span class="search-facet-result-count">$${tag.count}</span>
             </div>
         </li>
     </#list>

        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">portfolio</span>
                <span class="search-facet-result-count">3,530</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">responsive</span>
                <span class="search-facet-result-count">3,040</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">business</span>
                <span class="search-facet-result-count">2,937</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">modern</span>
                <span class="search-facet-result-count">2,861</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">creative</span>
                <span class="search-facet-result-count">2,821</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">corporate</span>
                <span class="search-facet-result-count">2,321</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">blog</span>
                <span class="search-facet-result-count">1,784</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">agency</span>
                <span class="search-facet-result-count">1,343</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">minimal</span>
                <span class="search-facet-result-count">1,272</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">parallax</span>
                <span class="search-facet-result-count">1,234</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">photography</span>
                <span class="search-facet-result-count">1,232</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">one page</span>
                <span class="search-facet-result-count">1,043</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">gallery</span>
                <span class="search-facet-result-count">990</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">multipurpose</span>
                <span class="search-facet-result-count">982</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">html5</span>
                <span class="search-facet-result-count">972</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">bootstrap</span>
                <span class="search-facet-result-count">967</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">jquery</span>
                <span class="search-facet-result-count">922</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">flat</span>
                <span class="search-facet-result-count">869</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">personal</span>
                <span class="search-facet-result-count">727</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">css3</span>
                <span class="search-facet-result-count">713</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">ecommerce</span>
                <span class="search-facet-result-count">711</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">fashion</span>
                <span class="search-facet-result-count">702</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">shop</span>
                <span class="search-facet-result-count">689</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">slider</span>
                <span class="search-facet-result-count">680</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">elegant</span>
                <span class="search-facet-result-count">562</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">retina</span>
                <span class="search-facet-result-count">551</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">professional</span>
                <span class="search-facet-result-count">544</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">magazine</span>
                <span class="search-facet-result-count">538</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">mobile</span>
                <span class="search-facet-result-count">537</span>
            </div>
        </li>
    </ul>

</div>

<div class="js-search-facet-panel__body search-facet-panel__body  is-visually-hidden--js">
<div class="search-facet-panel__body-inner">
<button class="js-search-facet-panel__body-close search-facet-panel__body-close">
    <i class="e-icon -icon-cancel">
        <span class="e-icon__alt">Close</span>
    </i>
</button>
<ul class="search-facet-multi-select-in-panel" data-view="multiSelectFacetToggle">
<#list tagsPage.content as tag>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 100.0%">
            <div class="search-facet-multi-select-panel__title-inner">${tag.tagName}</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        ${tag.count}
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-clean" name="tags[]" type="checkbox" value="clean">
    </label>
</li>

</#list>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 95.85%">
            <div class="search-facet-multi-select-panel__title-inner">portfolio</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        3,530
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-portfolio" name="tags[]" type="checkbox" value="portfolio">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 82.54%">
            <div class="search-facet-multi-select-panel__title-inner">responsive</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        3,040
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-responsive" name="tags[]" type="checkbox" value="responsive">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 79.74%">
            <div class="search-facet-multi-select-panel__title-inner">business</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        2,937
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-business" name="tags[]" type="checkbox" value="business">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 77.68%">
            <div class="search-facet-multi-select-panel__title-inner">modern</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        2,861
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-modern" name="tags[]" type="checkbox" value="modern">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 76.6%">
            <div class="search-facet-multi-select-panel__title-inner">creative</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        2,821
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-creative" name="tags[]" type="checkbox" value="creative">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 63.02%">
            <div class="search-facet-multi-select-panel__title-inner">corporate</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        2,321
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-corporate" name="tags[]" type="checkbox" value="corporate">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 48.44%">
            <div class="search-facet-multi-select-panel__title-inner">blog</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,784
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-blog" name="tags[]" type="checkbox" value="blog">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 36.46%">
            <div class="search-facet-multi-select-panel__title-inner">agency</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,343
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-agency" name="tags[]" type="checkbox" value="agency">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 34.54%">
            <div class="search-facet-multi-select-panel__title-inner">minimal</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,272
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-minimal" name="tags[]" type="checkbox" value="minimal">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 33.51%">
            <div class="search-facet-multi-select-panel__title-inner">parallax</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,234
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-parallax" name="tags[]" type="checkbox" value="parallax">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 33.45%">
            <div class="search-facet-multi-select-panel__title-inner">photography</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,232
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-photography" name="tags[]" type="checkbox" value="photography">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 28.32%">
            <div class="search-facet-multi-select-panel__title-inner">one page</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,043
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-one page" name="tags[]" type="checkbox" value="one page">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 26.88%">
            <div class="search-facet-multi-select-panel__title-inner">gallery</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        990
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-gallery" name="tags[]" type="checkbox" value="gallery">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 26.66%">
            <div class="search-facet-multi-select-panel__title-inner">multipurpose</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        982
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-multipurpose" name="tags[]" type="checkbox" value="multipurpose">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 26.39%">
            <div class="search-facet-multi-select-panel__title-inner">html5</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        972
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-html5" name="tags[]" type="checkbox" value="html5">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 26.26%">
            <div class="search-facet-multi-select-panel__title-inner">bootstrap</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        967
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-bootstrap" name="tags[]" type="checkbox" value="bootstrap">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 25.03%">
            <div class="search-facet-multi-select-panel__title-inner">jquery</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        922
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-jquery" name="tags[]" type="checkbox" value="jquery">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 23.59%">
            <div class="search-facet-multi-select-panel__title-inner">flat</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        869
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-flat" name="tags[]" type="checkbox" value="flat">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 19.74%">
            <div class="search-facet-multi-select-panel__title-inner">personal</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        727
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-personal" name="tags[]" type="checkbox" value="personal">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 19.36%">
            <div class="search-facet-multi-select-panel__title-inner">css3</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        713
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-css3" name="tags[]" type="checkbox" value="css3">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 19.3%">
            <div class="search-facet-multi-select-panel__title-inner">ecommerce</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        711
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-ecommerce" name="tags[]" type="checkbox" value="ecommerce">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 19.06%">
            <div class="search-facet-multi-select-panel__title-inner">fashion</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        702
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-fashion" name="tags[]" type="checkbox" value="fashion">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 18.71%">
            <div class="search-facet-multi-select-panel__title-inner">shop</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        689
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-shop" name="tags[]" type="checkbox" value="shop">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 18.46%">
            <div class="search-facet-multi-select-panel__title-inner">slider</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        680
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-slider" name="tags[]" type="checkbox" value="slider">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 15.26%">
            <div class="search-facet-multi-select-panel__title-inner">elegant</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        562
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-elegant" name="tags[]" type="checkbox" value="elegant">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 14.96%">
            <div class="search-facet-multi-select-panel__title-inner">retina</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        551
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-retina" name="tags[]" type="checkbox" value="retina">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 14.77%">
            <div class="search-facet-multi-select-panel__title-inner">professional</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        544
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-professional" name="tags[]" type="checkbox" value="professional">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 14.61%">
            <div class="search-facet-multi-select-panel__title-inner">magazine</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        538
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-magazine" name="tags[]" type="checkbox" value="magazine">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 14.58%">
            <div class="search-facet-multi-select-panel__title-inner">mobile</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        537
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="tags-mobile" name="tags[]" type="checkbox" value="mobile">
    </label>
</li>
</ul>

<div class="js-search-facet-toggle search-facet-panel-toggle" data-view="facetTogglePanel">
    <a href="#" class="js-search-facet-toggle__link">
        <span>
          <span class="e-icon -icon-preview"></span>
          <span class="search-facet-panel-toggle__remaining">
            Show remaining 16 options
          </span>
        </span>
        <span>Hide options</span>
    </a>      <div class="search-facet-panel__action">
    <button class="btn btn--primary btn--dimensions-full-width">Done</button>
</div>
</div>

</div>
</div>
</div>

<div class="search-facet--no-margin">
    <div class="search-facet-box">
        <div class="search-facet-box__inner">
            <h2 class="search-facet-box__heading"><i class="e-icon -icon-dollar -margin-right"></i>价格</h2>

            <div class="search-facet-range__inputs">
                <div class="js-search-facet-range__input search-facet-range__input--with-prefix">
                    <label for="price_min">从</label>
                    <span>￥</span>
                    <input data-validation-message="Please enter a positive dollar amount" data-view="searchInputValidation" id="price_min" name="price_min" placeholder="4" type="text">
                </div>

                <div class="js-search-facet-range__input search-facet-range__input--with-prefix">
                    <label for="price_max">到</label>
                    <span>￥</span>
                    <input data-validation-message="Please enter a positive dollar amount" data-view="searchInputValidation" id="price_max" name="price_max" placeholder="99" type="text">
                </div>

                <div class="search-facet-range__input--submit">
                    <button class="btn btn--size-m-inline no-label" type="submit">
                        <i class="e-icon -icon-search">
                            <span class="e-icon__alt">Apply</span>
                        </i>
                    </button>  </div>
            </div>

        </div>
    </div>
</div>

<div>
    <div class="search-facet-header">
        <h2><i class="e-icon -icon-bar-chart -margin-right"></i><span>Sales</span></h2>
    </div>

    <div class="group-select -border-top-none -border-radius-none">
        <label class="is-visually-hidden" for="sales">销量</label>
        <select data-pjax="" id="sales" name="sales"><option selected="selected" value="">销量: 显示所有</option>
            <option value="rank-0">没有销量No Sales - 27</option>
            <option value="rank-1">低Low - 112</option>
            <option value="rank-2">中等Medium - 3,238</option>
            <option value="rank-3">高High - 5,206</option>
            <option value="rank-4">最高Top Sellers - 279</option></select>
    </div>

</div>

<div>
    <div class="search-facet-header">
        <h2><i class="e-icon -icon-star -margin-right"></i><span>评级</span></h2>
    </div>

    <div class="group-select -border-top-none -border-radius-bottom">
        <label class="is-visually-hidden" for="rating_min">评级</label>
        <select data-pjax="" id="rating_min" name="rating_min"><option selected="selected" value="">Rating: Show all</option>
            <option value="1">1 star and higher - 5,980</option>
            <option value="2">2 stars and higher - 5,973</option>
            <option value="3">3 stars and higher - 5,887</option>
            <option value="4">4 stars and higher - 5,250</option></select>
    </div>

</div>

</div>

<div class="search-facet">
<div class="search-facet--no-margin">
<div class="js-search-facet-panel__header search-facet-panel__header--start">
    <h2 data-title="Software version"><i class="e-icon -icon-code -margin-right"></i>Software version</h2>


    <ul class="search-facet-listing">
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">WordPress</span>
                <span class="search-facet-result-count">3178</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Joomla</span>
                <span class="search-facet-result-count">497</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Magento</span>
                <span class="search-facet-result-count">210</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Drupal</span>
                <span class="search-facet-result-count">145</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">PrestaShop</span>
                <span class="search-facet-result-count">76</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">OpenCart</span>
                <span class="search-facet-result-count">67</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Ghost</span>
                <span class="search-facet-result-count">30</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Shopify</span>
                <span class="search-facet-result-count">25</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Moodle</span>
                <span class="search-facet-result-count">11</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Muse</span>
                <span class="search-facet-result-count">10</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Concrete5</span>
                <span class="search-facet-result-count">9</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Jekyll</span>
                <span class="search-facet-result-count">7</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">MODX</span>
                <span class="search-facet-result-count">7</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Zen</span>
                <span class="search-facet-result-count">7</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Mura</span>
                <span class="search-facet-result-count">6</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">phpBB</span>
                <span class="search-facet-result-count">4</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Sketch</span>
                <span class="search-facet-result-count">3</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">.NET</span>
                <span class="search-facet-result-count">1</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">CS-Cart</span>
                <span class="search-facet-result-count">1</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">osCommerce</span>
                <span class="search-facet-result-count">1</span>
            </div>
        </li>
    </ul>

</div>

<div class="js-search-facet-panel__body search-facet-panel__body  is-visually-hidden--js">
<div class="search-facet-panel__body-inner">
<button class="js-search-facet-panel__body-close search-facet-panel__body-close">
    <i class="e-icon -icon-cancel">
        <span class="e-icon__alt">Close</span>
    </i>
</button>
<div class="search-facet-panel__breadcrumbs-wrapper">
    <div class="search-facet-panel__breadcrumbs-intro">
        <span class="t-body -size-m">Show:</span>
    </div>
    <div class="search-facet-panel__breadcrumbs">
        <nav class="breadcrumbs -line-wrap -color-grey -icon-fill">
            <a href="/search?date=&amp;platform=&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" data-pjax="" rel="nofollow">
                All software versions <span class="breadcrumbs__count">8862</span>
            </a>
        </nav>
    </div>
</div>

<ul class="search-facet-single-select-in-panel">

<li class="">
    <a href="/search?date=&amp;platform=WordPress&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(100.0% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">WordPress</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    3,178
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=Joomla&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(15.64% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Joomla</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    497
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=Magento&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(6.61% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Magento</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    210
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=Drupal&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(4.56% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Drupal</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    145
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=PrestaShop&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(2.39% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">PrestaShop</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    76
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=OpenCart&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(2.11% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">OpenCart</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    67
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=Ghost&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.94% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Ghost</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    30
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=Shopify&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.79% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Shopify</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    25
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=Moodle&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.35% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Moodle</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    11
</div>
</li>

<li class="">
    <a href="/search?date=&amp;platform=Muse&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.31% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Muse</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    10
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=Concrete5&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.28% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Concrete5</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    9
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=Jekyll&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.22% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Jekyll</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    7
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=MODX&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.22% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">MODX</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    7
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=Zen&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.22% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Zen</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    7
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=Mura&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.19% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Mura</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    6
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=phpBB&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.13% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">phpBB</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    4
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=Sketch&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.09% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">Sketch</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    3
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=.NET&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.03% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">.NET</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    1
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=CS-Cart&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.03% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">CS-Cart</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    1
</div>
</li>

<li class="is-hidden js-collapsible">
    <a href="/search?date=&amp;platform=osCommerce&amp;price_max=&amp;price_min=&amp;rating_min=&amp;sales=&amp;sort=&amp;term=4&amp;utf8=%E2%9C%93&amp;view=list" rel="nofollow" style="min-width: 50%; width: calc(0.03% - 30px);">
        <div class="search-facet-single-select-panel__title">
            <div class="search-facet-single-select-panel__title-inner">osCommerce</div>
        </div>
    </a>        <div class="search-facet-single-select-panel__count">
    1
</div>
</li>
</ul>


<div class="js-search-facet-toggle search-facet-panel-toggle" data-view="facetTogglePanel">
    <a href="#" class="js-search-facet-toggle__link">
        <span>
          <span class="e-icon -icon-preview"></span>
          <span class="search-facet-panel-toggle__remaining">
            Show remaining 10 options
          </span>
        </span>
        <span>Hide options</span>
    </a>      <div class="search-facet-panel__action">
    <button class="js-search-facet-panel__body-close btn btn--primary btn--dimensions-full-width">Done</button>
</div>
</div>

</div>
</div>
</div>

<div class="search-facet--no-margin">
<div class="js-search-facet-panel__header search-facet-panel__header--end">
    <h2 data-title="Compatible with"><i class="e-icon -icon-code -margin-right"></i>Compatible with</h2>
    <ul class="search-facet-listing">
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Bootstrap</span>
                <span class="search-facet-result-count">3,985</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">WPML</span>
                <span class="search-facet-result-count">1,347</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">WooCommerce</span>
                <span class="search-facet-result-count">1,261</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Visual Composer</span>
                <span class="search-facet-result-count">984</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">bbPress</span>
                <span class="search-facet-result-count">189</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Gravity Forms</span>
                <span class="search-facet-result-count">137</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">BuddyPress</span>
                <span class="search-facet-result-count">135</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Events Calendar</span>
                <span class="search-facet-result-count">115</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Facebook</span>
                <span class="search-facet-result-count">103</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Foundation</span>
                <span class="search-facet-result-count">92</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">VirtueMart</span>
                <span class="search-facet-result-count">76</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Events Calendar Pro</span>
                <span class="search-facet-result-count">43</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Drupal Commerce</span>
                <span class="search-facet-result-count">36</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">AngularJS</span>
                <span class="search-facet-result-count">35</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Easy Digital Downloads</span>
                <span class="search-facet-result-count">31</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Instapage</span>
                <span class="search-facet-result-count">18</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">JomSocial</span>
                <span class="search-facet-result-count">18</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Layers WP</span>
                <span class="search-facet-result-count">16</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">WP e-Commerce</span>
                <span class="search-facet-result-count">10</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Moodle</span>
                <span class="search-facet-result-count">8</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Pagewiz</span>
                <span class="search-facet-result-count">8</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Ubercart</span>
                <span class="search-facet-result-count">6</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Jigoshop</span>
                <span class="search-facet-result-count">4</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Cart66</span>
                <span class="search-facet-result-count">3</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">WP EasyCart</span>
                <span class="search-facet-result-count">3</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">Magento Enterprise</span>
                <span class="search-facet-result-count">2</span>
            </div>
        </li>
        <li>
            <div class="search-facet-listing__link">
                <span class="search-facet-listing__label">iThemes Exchange</span>
                <span class="search-facet-result-count">2</span>
            </div>
        </li>
    </ul>

</div>

<div class="js-search-facet-panel__body search-facet-panel__body  is-visually-hidden--js">
<div class="search-facet-panel__body-inner">
<button class="js-search-facet-panel__body-close search-facet-panel__body-close">
    <i class="e-icon -icon-cancel">
        <span class="e-icon__alt">Close</span>
    </i>
</button>
<ul class="search-facet-multi-select-in-panel" data-view="multiSelectFacetToggle">
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 100.0%">
            <div class="search-facet-multi-select-panel__title-inner">Bootstrap</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        3,985
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Bootstrap" name="compatible_with[]" type="checkbox" value="Bootstrap">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 33.8%">
            <div class="search-facet-multi-select-panel__title-inner">WPML</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,347
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-WPML" name="compatible_with[]" type="checkbox" value="WPML">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 31.64%">
            <div class="search-facet-multi-select-panel__title-inner">WooCommerce</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        1,261
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-WooCommerce" name="compatible_with[]" type="checkbox" value="WooCommerce">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 24.69%">
            <div class="search-facet-multi-select-panel__title-inner">Visual Composer</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        984
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Visual Composer" name="compatible_with[]" type="checkbox" value="Visual Composer">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 4.74%">
            <div class="search-facet-multi-select-panel__title-inner">bbPress</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        189
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-bbPress" name="compatible_with[]" type="checkbox" value="bbPress">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 3.44%">
            <div class="search-facet-multi-select-panel__title-inner">Gravity Forms</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        137
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Gravity Forms" name="compatible_with[]" type="checkbox" value="Gravity Forms">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 3.39%">
            <div class="search-facet-multi-select-panel__title-inner">BuddyPress</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        135
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-BuddyPress" name="compatible_with[]" type="checkbox" value="BuddyPress">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 2.89%">
            <div class="search-facet-multi-select-panel__title-inner">Events Calendar</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        115
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Events Calendar" name="compatible_with[]" type="checkbox" value="Events Calendar">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 2.58%">
            <div class="search-facet-multi-select-panel__title-inner">Facebook</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        103
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Facebook" name="compatible_with[]" type="checkbox" value="Facebook">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 2.31%">
            <div class="search-facet-multi-select-panel__title-inner">Foundation</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        92
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Foundation" name="compatible_with[]" type="checkbox" value="Foundation">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 1.91%">
            <div class="search-facet-multi-select-panel__title-inner">VirtueMart</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        76
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-VirtueMart" name="compatible_with[]" type="checkbox" value="VirtueMart">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 1.08%">
            <div class="search-facet-multi-select-panel__title-inner">Events Calendar Pro</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        43
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Events Calendar Pro" name="compatible_with[]" type="checkbox" value="Events Calendar Pro">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.9%">
            <div class="search-facet-multi-select-panel__title-inner">Drupal Commerce</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        36
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Drupal Commerce" name="compatible_with[]" type="checkbox" value="Drupal Commerce">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.88%">
            <div class="search-facet-multi-select-panel__title-inner">AngularJS</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        35
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-AngularJS" name="compatible_with[]" type="checkbox" value="AngularJS">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.78%">
            <div class="search-facet-multi-select-panel__title-inner">Easy Digital Downloads</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        31
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Easy Digital Downloads" name="compatible_with[]" type="checkbox" value="Easy Digital Downloads">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.45%">
            <div class="search-facet-multi-select-panel__title-inner">Instapage</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        18
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Instapage" name="compatible_with[]" type="checkbox" value="Instapage">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.45%">
            <div class="search-facet-multi-select-panel__title-inner">JomSocial</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        18
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-JomSocial" name="compatible_with[]" type="checkbox" value="JomSocial">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.4%">
            <div class="search-facet-multi-select-panel__title-inner">Layers WP</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        16
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Layers WP" name="compatible_with[]" type="checkbox" value="Layers WP">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.25%">
            <div class="search-facet-multi-select-panel__title-inner">WP e-Commerce</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        10
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-WP e-Commerce" name="compatible_with[]" type="checkbox" value="WP e-Commerce">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.2%">
            <div class="search-facet-multi-select-panel__title-inner">Moodle</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        8
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Moodle" name="compatible_with[]" type="checkbox" value="Moodle">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.2%">
            <div class="search-facet-multi-select-panel__title-inner">Pagewiz</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        8
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Pagewiz" name="compatible_with[]" type="checkbox" value="Pagewiz">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.15%">
            <div class="search-facet-multi-select-panel__title-inner">Ubercart</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        6
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Ubercart" name="compatible_with[]" type="checkbox" value="Ubercart">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.1%">
            <div class="search-facet-multi-select-panel__title-inner">Jigoshop</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        4
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Jigoshop" name="compatible_with[]" type="checkbox" value="Jigoshop">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.08%">
            <div class="search-facet-multi-select-panel__title-inner">Cart66</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        3
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Cart66" name="compatible_with[]" type="checkbox" value="Cart66">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.08%">
            <div class="search-facet-multi-select-panel__title-inner">WP EasyCart</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        3
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-WP EasyCart" name="compatible_with[]" type="checkbox" value="WP EasyCart">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.05%">
            <div class="search-facet-multi-select-panel__title-inner">Magento Enterprise</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        2
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-Magento Enterprise" name="compatible_with[]" type="checkbox" value="Magento Enterprise">
    </label>
</li>
<li class="js-search-facet-multi-select-panel__option search-facet-multi-select-panel__option is-hidden js-collapsible">
    <label class="">
        <div class="search-facet-multi-select-panel__title" style="min-width: 50%; width: 0.05%">
            <div class="search-facet-multi-select-panel__title-inner">iThemes Exchange</div>
        </div>          <div class="search-facet-multi-select-panel__count">
        2
    </div>
        <div class="search-facet-multi-select-panel__status">
            <div>
                <i class="e-icon -icon-ok"><span class="e-icon__alt">selection active</span></i>
            </div>
            <div>
                <i class="e-icon -icon-cancel"><span class="e-icon__alt">remove selection</span></i>
            </div>
        </div>
        <input id="compatible_with-iThemes Exchange" name="compatible_with[]" type="checkbox" value="iThemes Exchange">
    </label>
</li>
</ul>

<div class="js-search-facet-toggle search-facet-panel-toggle" data-view="facetTogglePanel">
    <a href="#" class="js-search-facet-toggle__link">
        <span>
          <span class="e-icon -icon-preview"></span>
          <span class="search-facet-panel-toggle__remaining">
            Show remaining 13 options
          </span>
        </span>
        <span>Hide options</span>
    </a>      <div class="search-facet-panel__action">
    <button class="btn btn--primary btn--dimensions-full-width">Done</button>
</div>
</div>

</div>
</div>
</div>

</div>


<button class="btn--dimensions-full-width js-submit-button is-hidden" type="submit">Refine Search</button>

</div>


</form>





</div>
