package cv.zing.interview.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag extends BaseEntity{
    @Column(name = "tag", length = 100)
    private String tagName;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private Set<Post> posts;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
