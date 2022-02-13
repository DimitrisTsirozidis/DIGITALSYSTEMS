
package model.newsdb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "source",
    "author",
    "title",
    "description",
    "url",
    "urlToImage",
    "publishedAt",
    "content"
})

/*
 * 	{
 *    "source": {"id":"techcrunch","name":"TechCrunch"},
 *    "author":"Romain Dillet,Nariko Mizoguchi",
 *    "title":"アップル、オランダのマッチングアプリの代替決済システム使用に手数料27％を請求へ",
 *    "description":"<a target=\"_blank\" href=\"https://techcrunch.com/2022/01/17/apple-app-store-dutch-antitrust-order/\" rel=\"noopener\">裁判所の命令</a>により、マッチングアプリの開発者はオランダでApple（アップル）のアプリ内課金システムを使用する必要はなくなった。また、これらの課金決済はAppleによって処理されないため、Appleはデジタル購入の際に通常の30％の手数料を取ることはない。しかし、サードパーティの決…",
 *    "url":"https://jp.techcrunch.com/2022/02/05/2022-02-04-apple-to-charge-27-fee-for-dutch-dating-apps-using-alternative-payment-options/",
 *    "urlToImage":"https://jp.techcrunch.com/wp-content/uploads/2022/02/Apple.jpeg?w=1024",
 *    "publishedAt":"2022-02-04T23:30:44Z",
 *    "content":"AppleAppleApple30Apple27\r\nApplesuperlikeboost\r\nAppleApple\r\nApple\r\nACM1\r\nApple50065000\r\nApple24\r\nAppleAppleApp Store327\r\nACMAppleApple27%VAT\r\nApp StoreApple27%\r\nApple\r\n2\r\nAppleAppleAPI\r\nAppleApple\r\nAp… [+60 chars]"
 *   },
 */
@Generated("jsonschema2pojo")
public class Article implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("source")
    private Source source;
    @JsonProperty("author")
    private String author;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;
    @JsonProperty("urlToImage")
    private String urlToImage;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("content")
    private String content;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("urlToImage")
    public String getUrlToImage() {
        return urlToImage;
    }

    @JsonProperty("urlToImage")
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
