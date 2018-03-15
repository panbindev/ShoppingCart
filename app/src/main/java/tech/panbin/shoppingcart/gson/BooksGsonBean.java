package tech.panbin.shoppingcart.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PanBin on 2018/03/15.
 */

public class BooksGsonBean {


    /**
     * rating : {"max":10,"numRaters":2013,"average":"9.1","min":0}
     * subtitle :
     * author : ["Eric S. Raymond"]
     * pubdate : 2006-2
     * tags : [{"count":2416,"name":"UNIX","title":"UNIX"},{"count":1107,"name":"编程","title":"编程"},{"count":906,"name":"编程艺术","title":"编程艺术"},{"count":683,"name":"计算机","title":"计算机"},{"count":377,"name":"文化","title":"文化"},{"count":371,"name":"programming","title":"programming"},{"count":311,"name":"linux","title":"linux"},{"count":292,"name":"软件开发","title":"软件开发"}]
     * origin_title :
     * image : https://img3.doubanio.com/mpic/s1631790.jpg
     * binding : 平装
     * translator : ["姜宏","何源","蔡晓俊"]
     * catalog :
     * pages : 525
     * images : {"small":"https://img3.doubanio.com/spic/s1631790.jpg","large":"https://img3.doubanio.com/lpic/s1631790.jpg","medium":"https://img3.doubanio.com/mpic/s1631790.jpg"}
     * alt : https://book.douban.com/subject/1467587/
     * id : 1467587
     * publisher : 电子工业出版社
     * isbn10 : 7121021161
     * isbn13 : 9787121021169
     * title : UNIX编程艺术
     * url : https://api.douban.com/v2/book/1467587
     * alt_title :
     * author_intro :
     * summary : 本书主要介绍了Unix系统领域中的设计和开发哲学、思想文化体系、原则与经验，由公认的Unix编程大师、开源运动领袖人物之一Eric S. Raymond倾力多年写作而成。包括Unix设计者在内的多位领域专家也为本书贡献了宝贵的内容。本书内容涉及社群文化、软件开发设计与实现，覆盖面广、内容深邃，完全展现了作者极其深厚的经验积累和领域智慧。
     * price : 59.00元
     * series : {"id":"28503","title":"图灵程序设计丛书·Web开发系列"}
     * ebook_url : https://read.douban.com/ebook/37156518/
     * ebook_price : 25.00
     */

    @SerializedName("rating")
    private RatingBean rating;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("pubdate")
    private String pubdate;
    @SerializedName("origin_title")
    private String originTitle;
    @SerializedName("image")
    private String image;
    @SerializedName("binding")
    private String binding;
    @SerializedName("catalog")
    private String catalog;
    @SerializedName("pages")
    private String pages;
    @SerializedName("images")
    private ImagesBean images;
    @SerializedName("alt")
    private String alt;
    @SerializedName("id")
    private String id;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("isbn10")
    private String isbn10;
    @SerializedName("isbn13")
    private String isbn13;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("alt_title")
    private String altTitle;
    @SerializedName("author_intro")
    private String authorIntro;
    @SerializedName("summary")
    private String summary;
    @SerializedName("price")
    private String price;
    @SerializedName("series")
    private SeriesBean series;
    @SerializedName("ebook_url")
    private String ebookUrl;
    @SerializedName("ebook_price")
    private String ebookPrice;
    @SerializedName("author")
    private List<String> author;
    @SerializedName("tags")
    private List<TagsBean> tags;
    @SerializedName("translator")
    private List<String> translator;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAltTitle() {
        return altTitle;
    }

    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SeriesBean getSeries() {
        return series;
    }

    public void setSeries(SeriesBean series) {
        this.series = series;
    }

    public String getEbookUrl() {
        return ebookUrl;
    }

    public void setEbookUrl(String ebookUrl) {
        this.ebookUrl = ebookUrl;
    }

    public String getEbookPrice() {
        return ebookPrice;
    }

    public void setEbookPrice(String ebookPrice) {
        this.ebookPrice = ebookPrice;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public static class RatingBean {
        /**
         * max : 10
         * numRaters : 2013
         * average : 9.1
         * min : 0
         */

        @SerializedName("max")
        private int max;
        @SerializedName("numRaters")
        private int numRaters;
        @SerializedName("average")
        private String average;
        @SerializedName("min")
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/spic/s1631790.jpg
         * large : https://img3.doubanio.com/lpic/s1631790.jpg
         * medium : https://img3.doubanio.com/mpic/s1631790.jpg
         */

        @SerializedName("small")
        private String small;
        @SerializedName("large")
        private String large;
        @SerializedName("medium")
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class SeriesBean {
        /**
         * id : 28503
         * title : 图灵程序设计丛书·Web开发系列
         */

        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class TagsBean {
        /**
         * count : 2416
         * name : UNIX
         * title : UNIX
         */

        @SerializedName("count")
        private int count;
        @SerializedName("name")
        private String name;
        @SerializedName("title")
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}