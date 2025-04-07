package labs.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NetflixTitlesStats {
	
	
	/**
	 * Returns a list that contains the title with the shortest non-zero runtime 
	 * in the Stream.
	 * 
	 * If there are multiple titles with the shortest runtime, returns them
	 * all in the list.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a list that contains the title with the shortest non-zero runtime 
	 * in the Stream (or multiple if there are > 1)
	 */
	public static List<NetflixTitle> problem1_shortestRuntime(Stream<NetflixTitle> titles) {
		List<NetflixTitle> titleList = titles.collect(Collectors.toList());
		
		OptionalInt shortestRuntime = titleList.stream()
	            .filter(t -> t.getRuntime() > 0)
	            .mapToInt(NetflixTitle::getRuntime)
	            .min();
	    
	    if (shortestRuntime.isEmpty()) {
	        return new ArrayList<>();
	    }

	    int minRuntime = shortestRuntime.getAsInt();

	    return titleList.stream()
	    		.sorted((s, t) -> s.getTitle().compareTo(t.getTitle()))
	            .filter(t -> t.getRuntime() == minRuntime)
	            .collect(Collectors.toList());   
	}
	
	
	/**
	 * Given a Stream of NetflixTitles, returns the most number of genres in one title
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the most number of genres in one title
	 */
	public static int problem2_mostGenresInOneTitle(Stream<NetflixTitle> titles) {
		OptionalInt maxGenres = titles.mapToInt(w -> w.getGenres().size()).max();
		return maxGenres.isEmpty() ? 0 : maxGenres.getAsInt(); // FIX ME
	}
	
	
	/**
	 * Counts how many titles are produced in each country.
	 * Grabs all titles from the stream and groups them by production country. 
	 * Returns a Map<String, Long> that maps production countries to the number
	 * of titles produced in that country.
	 * 
	 * This map should be sorted in ascending order of production country.
	 * 
	 * If the stream is empty, returns an empty map.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a Map<String, Long> that maps production countries to the number
	 * of titles produced in that country
	 */
	public static Map<String, Long> problem3_countTitlesByProductionCountry(Stream<NetflixTitle> titles) {
		Map<String, Long> titlesByProdCountry = titles.filter(t -> t.getProductionCountries() != null)
				.flatMap(t -> t.getProductionCountries().stream())
				.filter(c -> !c.isEmpty())
				.collect(Collectors.groupingBy(
	                    c -> c,
	                    TreeMap::new,
	                    Collectors.counting()
	            ));
		return titlesByProdCountry;
	}
	
	
	/**
	 * Calculates what percentage of the titles in the stream are of the given genre
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param genre		genre to use for calculation
	 * 
	 * @return	percentage of the titles in the stream are of the given genre
	 */
	public static double problem4_getPercentageOfGenre(Stream<NetflixTitle> titles, String genre) {
		List<NetflixTitle> titleList = titles.collect(Collectors.toList());

	    long titlesSize = titleList.size();

	    long numGenreMatches = titleList.stream()
	            .filter(t -> t.getGenres() != null && t.getGenres().contains(genre))
	            .count();

	    if (titlesSize == 0) {
	        return 0.0;
	    }

	    return (numGenreMatches * 100.0) / titlesSize;
	}
	
	/**
	 * Given a Stream of NetflixTitles, returns a comma-separated string of all 
	 * the different genres in the stream, sorted in ascending lexicographic order
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a comma-separated string of all the different genres in 
	 * the stream, sorted in ascending lexicographic order
	 */
	public static String problem5_getGenres(Stream<NetflixTitle> titles) {
		
		String distinctGenres = titles.filter(t -> t.getGenres() != null)
				.flatMap(t -> t.getGenres().stream())
				.filter(g -> !g.isEmpty())
				.distinct()
				.sorted()
				.collect(Collectors.joining(", "));
		
		return distinctGenres; // FIX ME
	}
	
	
	/**
	 * Returns the most popular title (based on IMDB score) in the stream. 
	 * (Note that title with a blank IMDB score are considered to have a
	 * score of 0)
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the most popular title (based on IMDB score) in the stream
	 */
	public static Optional<NetflixTitle> problem6_getMostPopularTitle(Stream<NetflixTitle> titles) {
		List<NetflixTitle> titleList = titles.collect(Collectors.toList());
		OptionalDouble maxIMDB = titleList.stream()
	            .filter(t -> t.getImdbScore() >= 0)
	            .mapToDouble(NetflixTitle::getImdbScore)
	            .max();
		
		if (maxIMDB.isEmpty()) {
			return Optional.empty();
		}
		
		double largestIMDB = maxIMDB.getAsDouble();// FIX ME
		
		return titleList.stream()
				.filter(t -> t.getImdbScore() == largestIMDB)
				.findFirst();
	}
	
	
	/**
	 * Returns the average number of seasons of NetflixTitles in the stream. 
	 * Only take into account titles with non-zero, non-blank num seasons.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the average number of (non-zero, non-blank) seasons of NetflixTitles in the stream
	 */
	public static double problem7_getAverageNumSeasons(Stream<NetflixTitle> titles) {
		return titles.filter(t -> t.getNumSeasons() > 0)
				.mapToInt(w -> w.getNumSeasons())
				.average()
				.orElse(0); // FIX ME
	}
	
	
	/**
	 * Gets a list of titles made in a time frame, given an (inclusive) range of 
	 * years. Titles are sorted in ascending lexicographic order.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param minYear	lower bound of the range of years (inclusive)
	 * @param maxYear	upper bound of the range of years (inclusive)
	 * 
	 * @return	list of titles released in the time frame, sorted in ascending lexicographic order
	 */
	public static List<String> problem8_getTitlesReleasedInYears(Stream<NetflixTitle> titles,
			int minYear, int maxYear) {
		List<String> titlesReleasedInYears = titles.filter(t -> t.getReleaseYear() >= minYear && t.getReleaseYear() <= maxYear)
				.map(t -> t.getTitle())
				.sorted()
				.collect(Collectors.toList());
		return titlesReleasedInYears; // FIX ME
	}
	
	
	/**
	 * Returns the first NetflixTitle whose description contains the given string (ignoring case),
	 * or else null if none found. "First" here means the first title encountered, when 
	 * considering titles sorted in ascending lexicographic order. So if titles "A", "B", and "C"
	 * all contain the string, title "A" will be found first.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param str		string to search for in titles
	 * 
	 * @return	first NetflixTitle whose description contains the given string (ignoring case),
	 * or else null if none found
	 */
	public static NetflixTitle problem9_getFirstTitleContainingStringInDescription(Stream<NetflixTitle> titles,
			String str) {
		NetflixTitle firstContainingStr = titles.sorted((w, v) -> w.getTitle().compareTo(v.getTitle()))
				.filter(t -> t.getDescription().toLowerCase().contains(str.toLowerCase()))
				.findFirst()
				.orElse(null);
		return firstContainingStr; // FIX ME
	}
	
	
	/**
	 * Given a Stream of NetflixTitles, return the number of NetflixTitles whose title is
	 * a duplicate of another NetflixTitle (case-sensitive)
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the number of duplicate NetflixTitles
	 */
	public static long problem10_countDuplicateTitles(Stream<NetflixTitle> titles) {
		Map<String, Long> titleCounts = titles
	            .map(NetflixTitle::getTitle)
	            .collect(Collectors.groupingBy(
	                    title -> title,
	                    Collectors.counting()
	            ));

	    return titleCounts.values().stream()
	            .filter(count -> count > 1)
	            .mapToLong(count -> count - 1)
	            .sum(); // FIX ME
	}
}