#parse("Copyright.java")
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Optional;

#parse("Author.java")
public enum ${NAME} {

    ;
    
    private int value;
    
    private String name;
    
    ${NAME}(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Optional<${NAME}> findByInt(int value) {
        for (${NAME} item: ${NAME}.values()) {
            if (item.value == value) {
                return Optional.of(item);
            }
        }
        
        return Optional.empty();
    }

    public static Optional<${NAME}> findByString(String name) {
      for (${NAME} item: ${NAME}.values()) {
            if (item.name.equals(name)) {
                return Optional.of(item);
            }
        }
        
        return Optional.empty();
    }
    
    @JsonCreator
    public static ${NAME} findNullableByString(String name) {
      for (${NAME} item: ${NAME}.values()) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        
        return null;
    }

    @JsonValue
    public String toString() {
        return this.name;
    }
    
    public int toInt() {
        return this.value;
    }
}
