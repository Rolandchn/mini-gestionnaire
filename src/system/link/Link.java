package system.link;



public class Link{
    private LinkType linkType;
    private int lag;

    public Link(LinkType linkType){
        this(linkType, 0);
    }

    public Link(LinkType linkType, int lag){
        this.linkType = linkType;
        this.lag = lag;
    }


    public LinkType getLinkType(){
        return linkType;
    }

    public int getLag(){
        return lag;
    }
}