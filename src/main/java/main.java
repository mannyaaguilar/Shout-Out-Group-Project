import static spark.Spark.*;

public class main {
    public static void main(String[] args) {

        // tell server where to find files
        staticFileLocation("/public");

        // send html to client (Chrome)
        get("/",(request, response) -> {
            response.redirect("/index.html");
            return null;
        });

        // to send data from server (main.java) to client (Ajax get in client.js)
        get("/shoutoutlist",(request, response) -> {
            response.type("application/json");
            return "{\n" +
                    "  \"shoutouts\":\n" +
                    "  [\n" +
                    "    {\"name\" : \"Scott\" ,\n" +
                    "      \"quote\" : \"I like how you explain code.\"},\n" +
                    "    {\"name\" : \"Koddie\",\n" +
                    "      \"quote\" : \"Thanks to Koddie for the new snacks!\"},\n" +
                    "    {\"name\" : \"Mark\" ,\n" +
                    "      \"quote\" : \"Shout out to Mark! He's a great partner to work with.\"},\n" +
                    "    {\"name\" : \"Ted\"  ,\n" +
                    "      \"quote\" : \"Ted helped me to better understand my weekend challenge.\"},\n" +
                    "    {\"name\" : \"Joan\" ,\n" +
                    "      \"quote\" : \"Joan helped me better understand the mini challenge.\"},\n" +
                    "    {\"name\" : \"Lori\" ,\n" +
                    "      \"quote\" : \"I think Lori is thinking like a programmer and asking great questions.\"},\n" +
                    "    {\"name\" : \"Manny\" ,\n" +
                    "      \"quote\" : \"Manny his patience and explanations helped me process the peer challenge.\"},\n" +
                    "    {\"name\" : \"Zech\"  ,\n" +
                    "      \"quote\" : \"Zech walked me through each step and explained things that were confusing to me.\"},\n" +
                    "    {\"name\" : \"Kym\" ,\n" +
                    "      \"quote\" : \"Kym was helpful and patient.\"},\n" +
                    "    {\"name\" : \"Jake\" ,\n" +
                    "      \"quote\" : \"Shout out to Jake for working out our group challenge on the timer project.\"}\n" +
                    "  ]\n" +
                    "}";
        });

    } // psvm
} // main class
