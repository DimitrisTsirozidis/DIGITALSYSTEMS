package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.newsdb.NewsResult;
import model.newsdb.Source;

public class Result {

	NewsResult result;
	
	public Result() {}
	

	
	
	
}


/*
Afto mou erxetai apo to Http ena HashMap 
{
	"status":"ok",
	"totalResults":2465,
	"articles":
     [
         {
	         "source":{"id":"engadget","name":"Engadget"},
	         "author":"Igor Bonifacic",
	         "title":"The free trial of Apple Music was quietly reduced to a single month",
	         "description":"Since its debut in 2015, Apple Music has offered one of the more generous free trial periods in the streaming industry. As a first-time subscriber, you could use the platform to listen to music for free for up to three months before the company asked you to s…",
	         "url":"https://www.engadget.com/apple-music-one-month-trial-period-223911452.html",
	         "urlToImage":"https://s.yimg.com/os/creatr-uploaded-images/2021-06/abb0de60-c831-11eb-9ebf-fd23496f2550",
	         "publishedAt":"2022-02-04T22:39:11Z",
	         "content":"Since its debut in 2015, Apple Music has offered one of the more generous free trial periods in the streaming industry. As a first-time subscriber, you could use the platform to listen to music for f… [+1312 chars]"},{"source":{"id":"engadget","name":"Engadget"},"author":"Devindra Hardawar","title":"Engadget Podcast: Sony buys Bungie, Spotify’s Joe Rogan dilemma","description":"This week, Cherlynn and Devindra chat with Senior Editor Jessica Conditt about Sony’s surprising $3.6 billion Bungie acquisition. It’s too soon for it to be a direct response to the Microsoft/Activision deal, but clearly Sony sees the need for new blood. Also…","url":"https://www.engadget.com/engadget-podcast-sony-bungie-spotify-joe-rogan-133014207.html","urlToImage":"https://s.yimg.com/os/creatr-uploaded-images/2020-11/c8e851c0-2b3d-11eb-baea-6c6fe29971fb","publishedAt":"2022-02-04T13:30:14Z","content":"This week, Cherlynn and Devindra chat with Senior Editor Jessica Conditt about Sonys surprising $3.6 billion Bungie acquisition. Its too soon for it to be a direct response to the Microsoft/Activisio… [+1066 chars]"},{"source":{"id":"the-verge","name":"The Verge"},"author":"Victoria Song","title":"Les Mills is jumping into the metaverse with VR boxing","description":"Les Mills is launching the BODYCOMBAT VR app, which combines a boxing workout with gaming on the Quest platform. The $29.99 game involves setting traditional boxing moves to music against scenic VR backgrounds.","url":"https://www.theverge.com/2022/2/4/22917669/les-mills-quest-meta-fitness-vr-boxing-metaverse","urlToImage":"https://cdn.vox-cdn.com/thumbor/z3ccMocRev3Xoi65WjZ3_TgegOk=/0x50:2560x1390/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/23217963/Les_Mills.jpg","publishedAt":"2022-02-04T16:36:02Z","content":"The tech-savvy gym is among the first to launch its own fitness game\r\nIf you buy something from a Verge link, Vox Media may earn a commission. See our ethics statement.\r\nThe Les Mills BODYCOMBAT VR a… [+3165 chars]"},{"source":{"id":null,"name":"Gizmodo.com"},"author":"Phillip Tracy","title":"Buying a TV for the Super Bowl? Here’s What You Need to Know","description":"Super Bowl LVI is set: The Los Angeles Rams will host the Cincinnati Bengals at SoFi Stadium on Feb. 13. If the last few rounds of playoff games are any indication, this Super Bowl will be one to remember. After all, the past five games prior to the Rams defe…","url":"https://gizmodo.com/how-to-buy-the-best-tv-1848469248","urlToImage":"https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/0782788b9f2c7a172a8aca6c68f2fd01.jpg","publishedAt":"2022-02-04T19:50:00Z","content":"Super Bowl LVI is set: The Los Angeles Rams will host the Cincinnati Bengals at SoFi Stadium on Feb. 13. If the last few rounds of playoff games are any indication, this Super Bowl will be one to rem… [+13212 chars]"},{"source":{"id":"ars-technica","name":"Ars Technica"},"author":"Scharon Harding","title":"Doomscroll forever with ultra-tall 5:16 portable monitor","description":"7.9-inch monitor feeds our obsession with feeds.","url":"https://arstechnica.com/gadgets/2022/02/ultra-tall-portable-monitor-is-a-516-portal-to-perpetual-newsfeeds/","urlToImage":"https://cdn.arstechnica.net/wp-content/uploads/2022/02/listing-1-760x380.jpg","publishedAt":"2022-02-04T16:56:55Z","content":"10 with 10 posters participating\r\nIn the world of displays, no one size or shape fits all. Over the past few years, we've seen more laptop screens play with aspect ratios that provide more vertical h… [+2081 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Apple, Broadcom get new damages trial in $1.1 billion CalTech patent case - Reuters","description":"Apple Inc <a href=\"https://www.reuters.com/companies/AAPL.O\" target=\"_blank\">(AAPL.O)</a> and Broadcom Inc <a href=\"https://www.reuters.com/companies/AVGO.O\" target=\"_blank\">(AVGO.O)</a>on Friday persuaded a U.S. appeals court to throw out a jury verdict requ…","url":"https://www.reuters.com/technology/apple-broadcom-get-new-damages-trial-11-billion-caltech-patent-case-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/qP0T01tZ5z_pFI50lV-GxD7DX0w=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/7PLKV5VLLRJOZCVP33L5H3MRJA.jpg","publishedAt":"2022-02-04T14:37:00Z","content":"Feb 4 (Reuters) - Apple Inc (AAPL.O) and Broadcom Inc (AVGO.O)on Friday persuaded a U.S. appeals court to throw out a jury verdict requiring them to pay $1.1 billion for infringing California Institu… [+1441 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Apple wins new trial in wireless patent case after $85 mln loss - Reuters","description":"Apple convinced a U.S. appeals court on Friday to throw out a jury's $85 million award to Canadian patent-licensing company Wi-LAN in a fight over wireless technology, setting the stage for another trial to determine damages in the case.","url":"https://www.reuters.com/legal/transactional/apple-wins-new-trial-wireless-patent-case-after-85-mln-loss-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/DTAXw0lXICv6x4vHdT05Xg6-R_E=/728x381/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/NULLA52HZFOR7LTTW5AM6QC3SQ.jpg","publishedAt":"2022-02-04T19:10:00Z","content":"The company and law firm names shown above are generated automatically based on the text of the article. We are improving this feature as we continue to test and develop in beta. We welcome feedback,… [+2628 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Apple plans to debut low cost 5G iPhone in March - Bloomberg News - Reuters","description":"Apple Inc <a href=\"https://www.reuters.com/companies/AAPL.O\" target=\"_blank\">(AAPL.O)</a> is targeting a date on or near March 8 to unveil a low-cost 5G iPhone and an updated iPad, Bloomberg News reported on Friday, citing people with knowledge of the matter.","url":"https://www.reuters.com/technology/apple-plans-debut-low-cost-5g-iphone-march-bloomberg-news-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/-DGLk-VWM4LyfDI0Eh6PpDI8Q0o=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/C2RQDP2THFNQTPV5WYXHKB7IIQ.jpg","publishedAt":"2022-02-04T20:45:00Z","content":"Feb 4 (Reuters) - Apple Inc (AAPL.O) is targeting a date on or near March 8 to unveil a low-cost 5G iPhone and an updated iPad, Bloomberg News reported on Friday, citing people with knowledge of the … [+999 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Analysis: Digital ad minnows Snap, Pinterest soar past giant Meta - Reuters","description":"For years, investors have wondered about the long-term prospects for Snap Inc <a href=\"https://www.reuters.com/companies/SNAP.N\" target=\"_blank\">(SNAP.N)</a> and Pinterest Inc <a href=\"https://www.reuters.com/companies/PINS.N\" target=\"_blank\">(PINS.N)</a>, sm…","url":"https://www.reuters.com/technology/digital-ad-minnows-snap-pinterest-soar-past-giant-meta-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/pRlTQIjSYdXZaWxW0e3ydV4k9oY=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/XBCLJQM3FNN65P37J2VNYJZR5E.jpg","publishedAt":"2022-02-04T15:40:00Z","content":"Feb 4 (Reuters) - For years, investors have wondered about the long-term prospects for Snap Inc (SNAP.N) and Pinterest Inc (PINS.N), smaller digital ad players which have had to pick up the ad dollar… [+3385 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Amazon has a unique inflation problem - Reuters","description":"Amazon.com is an atypical technology giant. Like peers, the $1.4 trillion online retailer dominates markets and has businesses that are growing rapidly. Yet Amazon has a workforce 10 times the size of Microsoft <a href=\"https://www.reuters.com/companies/MSFT.…","url":"https://www.reuters.com/breakingviews/amazon-has-unique-inflation-problem-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/ukeWItrVaLQR3zsLO81-zeUkbw8=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/3JKETF4LCBMIDMKUTPZB6QGEZA.jpg","publishedAt":"2022-02-04T00:13:00Z","content":"NEW YORK, Feb 3 (Reuters Breakingviews) - Amazon.com is an atypical technology giant. Like peers, the $1.4 trillion online retailer dominates markets and has businesses that are growing rapidly. Yet … [+3611 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Futures bolstered by Amazon results ahead of jobs report - Reuters","description":"U.S. stock index futures rebounded on Friday as Amazon.com Inc's robust earnings for the holiday reason lifted the mood at the end of a week of volatile trading that saw mixed earnings from Big Tech firms.","url":"https://www.reuters.com/business/futures-bolstered-by-amazon-results-ahead-jobs-report-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/XB5mjB59GBaVs0hgbJYcZQFEHKQ=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/TYYXITSMYNONJMLGTMJJFDVFTI.jpg","publishedAt":"2022-02-04T10:34:00Z","content":"Feb 4 (Reuters) - U.S. stock index futures rebounded on Friday as Amazon.com Inc's robust earnings for the holiday reason lifted the mood at the end of a week of volatile trading that saw mixed earni… [+1577 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Amazon surges, eyes Wall Street record gain in value - Reuters","description":"A day after Facebook owner Meta Platforms <a href=\"https://www.reuters.com/companies/FB.O\" target=\"_blank\">(FB.O)</a> suffered the biggest loss of stock market value in history for a U.S. company, Amazon was on track to log the greatest ever one-day increase …","url":"https://www.reuters.com/business/amazon-surges-eyes-wall-street-record-gain-value-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/4VJB3Nd2izXGUBkKB1HOYyalaEQ=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/HEEGIGOO6ZKVNB3MFM7IQPMLJU.jpg","publishedAt":"2022-02-04T18:35:00Z","content":"Feb 4 (Reuters) - A day after Facebook owner Meta Platforms (FB.O) suffered the biggest loss of stock market value in history for a U.S. company, Amazon was on track to log the greatest ever one-day … [+1797 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Southwest Airlines to bring alcohol back on planes after nearly two years - Reuters","description":"Southwest Airlines Co <a href=\"https://www.reuters.com/companies/LUV.N\" target=\"_blank\">(LUV.N)</a> will resume alcohol sales on its flights this month after nearly two years, the Texas-based carrier said on Thursday, a pause it extended last year due to a su…","url":"https://www.reuters.com/business/aerospace-defense/southwest-airlines-bring-alcohol-back-planes-after-nearly-two-years-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/wElC4HfipSKewK200f2ZLWZmQDI=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/MTM5UX6ZVVLRNE25O7YCL4QHHI.jpg","publishedAt":"2022-02-04T04:07:00Z","content":"Feb 3 (Reuters) - Southwest Airlines Co (LUV.N) will resume alcohol sales on its flights this month after nearly two years, the Texas-based carrier said on Thursday, a pause it extended last year due… [+2125 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Global tech stocks stage tentative recovery after Meta rout - Reuters","description":"Tech stocks staged a tentative rebound across financial markets on Friday as stellar results from Amazon <a href=\"https://www.reuters.com/quote/.AMZN\" target=\"_blank\">(.AMZN)</a> convinced traders not to give up on a sector weakened by a global monetary tight…","url":"https://www.reuters.com/business/finance/global-tech-stocks-stage-tentative-recovery-after-meta-rout-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/7CwSva8kNuiBJ2hhxlr8gnJVz4Y=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/SJOPRVMT6NNMVEMF3OIMX5HT5Q.jpg","publishedAt":"2022-02-04T11:18:00Z","content":"Feb 4 (Reuters) - Tech stocks staged a tentative rebound across financial markets on Friday as stellar results from Amazon (.AMZN) convinced traders not to give up on a sector weakened by a global mo… [+2598 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Global equity funds see biggest inflow in three weeks - Reuters","description":"Global equity funds lured big inflows in the seven days to Feb. 2 on optimism over strong earnings from U.S. technology companies and on hopes that inflation would ease later this year.","url":"https://www.reuters.com/business/finance/global-markets-flows-graphic-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/tUJG1PLJUGgxzD3qt_8HuBj36ng=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/KMVHCJW2UZPGBOJAR6YP4KHSTQ.jpg","publishedAt":"2022-02-04T13:59:00Z","content":"Feb 4 (Reuters) - Global equity funds lured big inflows in the seven days to Feb. 2 on optimism over strong earnings from U.S. technology companies and on hopes that inflation would ease later this y… [+2165 chars]"},{"source":{"id":"reuters","name":"Reuters"},"author":null,"title":"Automakers, chip firms differ on when semiconductor shortage will abate - Reuters","description":"Automakers, including General Motors <a href=\"https://www.reuters.com/companies/GM.N\" target=\"_blank\">(GM.N)</a>, Ford Motor <a href=\"https://www.reuters.com/companies/F.N\" target=\"_blank\">(F.N)</a> and Hyundai Motor <a href=\"https://www.reuters.com/companies…","url":"https://www.reuters.com/business/autos-transportation/automakers-chip-firms-differ-when-semiconductor-shortage-will-abate-2022-02-04/","urlToImage":"https://www.reuters.com/resizer/_iBfye1RhIf9caC8Fmt6Dx6Ldc8=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/W3NOV7GNFZNPHMW2M4HDKZFGIM.jpg","publishedAt":"2022-02-04T11:05:00Z","content":"SAN FRANCISCO, Feb 4 (Reuters) - Automakers, including General Motors (GM.N), Ford Motor (F.N) and Hyundai Motor (005380.KS) predict a near two-year chip constraint will ease in the second half of 20… [+4559 chars]"},{"source":{"id":null,"name":"Android Central"},"author":"Keegan Prosser","title":"Is Samsung TV Plus or Pluto TV better for free channels?","description":"Streaming on Samsung\n\nSamsung TV Plus\n\n\n\nFree at Samsung\n\nPros\n\n\nFree TV\nAvailable via web browser\nAbility to set reminders\n\n\nCons\n\n\nLimited to Samsung smart TVs\nLess channels than Pluto TV\nNo DVR functionality \n\n\nSamsung TV Plus is an online and app-based vi…","url":"https://www.androidcentral.com/samsung-tv-plus-vs-pluto-tv","urlToImage":"https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/article_images/2022/01/samsung-tv-plus-guide-lifestyle.jpg","publishedAt":"2022-02-04T20:00:02Z","content":"Samsung TV Plus is an online and app-based video service that gives users access to roughly 190 channels spanning news, entertainment, sports, and more. You'll also find a selection of movies and tel… [+6321 chars]"},{"source":{"id":null,"name":"The Guardian"},"author":"Emma Brockes","title":"Digested week: a night out at the circus leaves lots to think about | Emma Brockes","description":"Like other modern entertainment, a self-help script aims to lift the evening from merely diverting to inspirationalAt the weekend, we went to the Big Apple Circus, and let me tell you those places have changed. Instead of a sad elephant chained up outside the…","url":"https://amp.theguardian.com/uk-news/2022/feb/04/digested-week-night-circus-leaves-lots-think-about","urlToImage":"https://i.guim.co.uk/img/media/66898dd65e13cb8a7b0cca844e0e9a0c52883acf/0_0_5678_3409/master/5678.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctb3BpbmlvbnMucG5n&enable=upscale&s=d758ad9e93390a68c2d0c226872d48c9","publishedAt":"2022-02-04T11:52:54Z","content":"Monday\r\nAt the weekend, we went to the Big Apple Circus, and let me tell you those places have changed. Instead of a sad elephant chained up outside the Big Top standard in my childhood, unthinkable … [+7180 chars]"},{"source":{"id":null,"name":"The Guardian"},"author":"Lucy Mangan","title":"Suspicion review – blink and you’ll miss Uma Thurman in this kidnap thriller","description":"Why did a fake member of the royal family stuff a student into a suitcase? Could four unconnected Brits be to blame? And how did Thurman get so much press for such a tiny cameo? Generally speaking, I’m a fan of what we might call the unlocked room mystery. Th…","url":"https://amp.theguardian.com/tv-and-radio/2022/feb/04/suspicion-review-blink-and-youll-miss-uma-thurman-in-this-kidnap-thriller","urlToImage":"https://i.guim.co.uk/img/media/8d7164640a27dfd9fa58c5cf259ab44e0d4d4fd5/0_486_3901_2341/master/3901.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctcmV2aWV3LTMucG5n&enable=upscale&s=4b7ba9f685764970d1d78d4831f65076","publishedAt":"2022-02-04T06:00:20Z","content":"Generally speaking, Im a fan of what we might call the unlocked room mystery. The kind where someone is murdered or otherwise indisposed and we are then introduced to a wide variety of characters who… [+4057 chars]"},{"source":{"id":null,"name":"The Guardian"},"author":"Hollie Richardson, Phil Harrison, Graeme Virtue, Hannah Verdier and Simon Wardell","title":"TV tonight: the Winter Olympics are here","description":"Clare Balding kicks off the daily Games roundup with the Beijing opening ceremony. Plus, Uma Thurman joins Graham Norton. Here’s what to watch tonight Continue reading...","url":"https://amp.theguardian.com/tv-and-radio/2022/feb/04/tv-tonight-highlights-winter-olympics-opening-ceremony-beijing-clare-balding","urlToImage":"https://i.guim.co.uk/img/media/d3d81a560020a8acd5872e30686bca5f5533b65b/275_0_8259_4956/master/8259.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctZGVmYXVsdC5wbmc&enable=upscale&s=f96db461628f021dd537c13f44a87876","publishedAt":"2022-02-04T06:20:19Z","content":"Winter Olympics Today at the Games\r\n7pm, BBC Two\r\nCan Scottish curlers Jen Dodds and Bruce Mouat turn their world mixed doubles title into an Olympic gold medal? Will Lancastrian skier Dave Ryding gr… [+2856 chars]"
         },
         {
         
         }
      ]
 }



*/