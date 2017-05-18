package com.mycompany.bologsaggregator.Hibernate.Session;

import com.mycompany.bologsaggregator.Hibernate.Entity.Item;
import com.mycompany.bologsaggregator.JAXB.ObjectFactory;
import com.mycompany.bologsaggregator.JAXB.TRss;
import com.mycompany.bologsaggregator.JAXB.TRssChannel;
import com.mycompany.bologsaggregator.JAXB.TRssItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import org.springframework.stereotype.Service;


@Service
public class RssService {
    
    public List<Item> getItems(Source source) throws JAXBException, ParseException{
        
        ArrayList<Item>list=new ArrayList<Item>();
        
        JAXBContext jaxbContex = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller Unmarshaller = jaxbContex.createUnmarshaller();
        JAXBElement<TRss> jaxbElement = Unmarshaller.unmarshal(source,TRss.class);
        TRss value = jaxbElement.getValue();
        List<TRssChannel> channels = value.getChannel();
        
        for(TRssChannel channel:channels){
            List<TRssItem> items = channel.getItem();
            for(TRssItem rssitem:items){
                Item item=new Item();
                item.setItemTitle(rssitem.getTitle());
                item.setItemDescriptions(rssitem.getDescription());
                item.setItemLink(rssitem.getLink());
                Date pubDate = new SimpleDateFormat("EEE, dd MMM YYYY HH:mm:ss Z",Locale.ENGLISH).parse(rssitem.getPubDate());
                item.setItemPublishedDate(pubDate);
                list.add(item);
                
            }
        }
        return list;
        
    }
    
    
    
    
}
