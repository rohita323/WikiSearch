package Parser;

public class WikiPage {

	  private String id; 
	  private String title;
	  private String text;
		  
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
	  
	
	  public String getText() {
	    return text;
	  }

	  public void setText(String text) {
		   this.text = text;
		  }
	  
	  @Override
	  public String toString() {
	    return "Wiki Page [id=" + id + ", title=" + title + ", text="
	        + text + "]";
	  }
	
}
