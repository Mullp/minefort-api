import me.mullp.MinefortApi;
import me.mullp.icon.Icon;
import me.mullp.server.ServerState;
import me.mullp.util.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GetIconsTest {
  @Test
  @DisplayName("Get icons")
  public void testGetIcons() {
    MinefortApi minefortApi = new MinefortApi();
    minefortApi.getHttpClient().setSessionToken("");

    List<Icon> icons = minefortApi.getIconManager().getIcons().join();

    Assertions.assertEquals(ArrayList.class, icons.getClass());
  }
}
