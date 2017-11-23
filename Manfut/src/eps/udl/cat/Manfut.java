package eps.udl.cat;

import java.util.Locale;
import java.util.ResourceBundle;

public class Manfut {

    public static void main(String[] args)
    {

        String language;
        String country;

        Market          PlayersMarket;
        int             PresupostFitxatges;
        JugadorsEquip   MillorEquip;
        Error           err;

        // Procesar argumentos.
        if (args.length<2)
            throw new IllegalArgumentException(ResourceBundle.getBundle("ResourceBundles", Locale.getDefault()).getString("ERR_ARGUMENTS"));

        PresupostFitxatges = Integer.parseInt(args[0]);
        PlayersMarket = new Market();

         err = PlayersMarket.LlegirFitxerJugadors(args[1]);
         if (err!=Error.COk)
             System.err.println("[Manfut]" + ResourceBundle.getBundle("ResourceBundles", Locale.getDefault()).getString("ERR_READING_FILE"));

        // Calculate the best team.
        MillorEquip=PlayersMarket.CalcularEquipOptim(PresupostFitxatges);
        System.out.print(Error.color_blue);
        System.out.println(ResourceBundle.getBundle("ResourceBundles", Locale.getDefault()).getString("BEST_TEAM"));
        MillorEquip.PrintEquipJugadors();
        System.out.println(ResourceBundle.getBundle("ResourceBundles", Locale.getDefault()).getString("COST") + MillorEquip.CostEquip() +ResourceBundle.getBundle("ResourceBundles", Locale.getDefault()).getString("POINTS") + MillorEquip.PuntuacioEquip() + ".");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.print(Error.end_color);

        System.exit(0);
    }


    // Methods Definition
    static int log(int x, int base)
    {
        return (int) Math.ceil((Math.log(x) / Math.log(base)));
    }

    static long log(long x, int base)
    {
        return (long) Math.ceil((Math.log(x) / Math.log(base)));
    }

    static int Log2(int x)
    {
        return (int) (log(x,2) );
    }

    static long Log2(long x)
    {
        return (long) (log(x,2) );
    }
}
