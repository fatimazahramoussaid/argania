package cloudcode.guestbook.backend;

/**
 * defines the data associated with a single guest book entry
 */
public class FeatureEntry {

    private String id;
    private String title;
    private String description;
    private String featuredetail;
    private String swaggerfile;
    private String userstories;
    private String anomalies;
    private String technologies;
    private String cloudtools;
    private String architecturepath;
    private String graphicdesignpath;
    private String prerequisite;

    public final String getid() {
        return id;
    }

    public final void setid(String id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final String getfeaturedetail() {
        return featuredetail;
    }

    public final void setfeaturedetail(String featuredetail) {
        this.featuredetail = featuredetail;
    }

    public final String getAnomalies() {
        return anomalies;
    }

    public final void setAnomalies(String anomalies) {
        this.anomalies = anomalies;
    }

    public final String getTechnologies() {
        return technologies;
    }

    public final void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public final String getcloudtools() {
        return cloudtools;
    }

    public final void setcloudtools(String cloudtools) {
        this.cloudtools = cloudtools;
    }

    public final String getuserstories() {
        return userstories;
    }

    public final void setuserstories(String userstories) {
        this.userstories = userstories;
    }

    public final String getSwaggerFile() {
        return swaggerfile;
    }

    public final void setSwaggerFile(String swaggerfile) {
        this.swaggerfile = swaggerfile;
    }

    public final String getArchitecturePath() {
        return this.architecturepath;
    }

    public final void setArchitecturePath(String architecturepath) {
        this.architecturepath = architecturepath;
    }

    public final String getGraphicDesignPath() {
        return this.graphicdesignpath;
    }

    public final void setGraphicDesignPath(String graphicdesignpath) {
        this.graphicdesignpath = graphicdesignpath;
    }

    public final String getPrerequisite() {
        return this.prerequisite;
    }

    public final void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }
}
