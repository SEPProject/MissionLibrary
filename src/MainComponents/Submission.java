package MainComponents;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class Submission {
    /**
     * A submission is just a sub section of a mission in order to be
     * able to separate every part of the mission
     */

    private String name;
    private String description;

    public Submission (String name){
        this.name = name;
    }

    public Submission (String name,String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
