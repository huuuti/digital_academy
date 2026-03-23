package Task3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TestsData {
    int id;
    String title;
    String value;
    @JsonIgnoreProperties(ignoreUnknown = true)
    List<TestsData> values;

    @Override
    public String toString() {
        return String.format("{\"id\":%s,\"title\":\"%s\",\"value\":\"%s\"}",
               this.id, this.title, this.value);
    }
}
