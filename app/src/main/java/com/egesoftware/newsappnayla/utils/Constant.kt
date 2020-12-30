package com.egesoftware.newsappnayla.utils

object Constant {

    const val BASE_URL_GITHUB = "https://api.github.com/"
    const val API_KEY = "YOUR_GUARDIAN_NEWS_API_KEY" //TODO TEST Daha sonra -- BuildConfig içine saklanacak
    const val REQUEST_TIMEOUT_DURATION = 10
    const val DEBUG = true

    /** URL for news data from the guardian data set  */
    const val BASE_URL = "https://content.guardianapis.com/"

    /** Parameters  */
    const val QUERY_PARAM = "q"
    const val ORDER_BY_PARAM = "order-by"
    const val PAGE_SIZE_PARAM = "page-size"
    const val ORDER_DATE_PARAM = "order-date"
    const val FROM_DATE_PARAM = "from-date"
    const val SHOW_FIELDS_PARAM = "show-fields"
    const val FORMAT_PARAM = "format"
    const val SHOW_TAGS_PARAM = "show-tags"
    const val API_KEY_PARAM = "api-key"
    const val SECTION_PARAM = "section"

    /** The show fields we want our API to return  */
    const val SHOW_FIELDS = "thumbnail,trailText"

    /** The format we want our API to return  */
    const val FORMAT = "json"

    /** The show tags we want our API to return  */
    const val SHOW_TAGS = "contributor"

    const val TITLE = "title"
    const val DESC = "description"
    const val CATEGORY = "category"
    const val DATE = "date"
    const val IMAGE_URL = "image_url"
    const val WEB_URL = "url"

}