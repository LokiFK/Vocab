package vocabs;

public class Vokabelkasten {

  private final Vokabel[] vokabelfeld;

  public Vokabelkasten(int anzahl) {
    vokabelfeld = new Vokabel[anzahl];
  }

  public boolean addVokabel(Vokabel v) {
    for (int i = 0; i < vokabelfeld.length; i++) {
      if (vokabelfeld[i] == null) {
        vokabelfeld[i] = v;
        return true;
      }
    }
    return false;
  }

  public int getVokabelanzahl() {
    int i = 0;
    while (i < vokabelfeld.length) {
      i++;
    }
    return i;
  }

  public Vokabel getVokabel(int nr) {
    return vokabelfeld[nr];
  }

  public boolean deleteVokabel(String deutsch) {
    for (Vokabel vokabel : vokabelfeld) {
      if (vokabel.toString().equals(deutsch))
        vokabel = null;
      return vokabel == null;
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (Vokabel vokabel : vokabelfeld) {
      if (vokabel != null) {
        output.append(("\n")).append(vokabel.toString());
      }
    }
    return output.toString();
  }

}
