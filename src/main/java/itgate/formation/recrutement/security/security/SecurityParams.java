package itgate.formation.recrutement.security.security;

public interface SecurityParams {
    String JWT_HEADER_NAME="Authorization";
    String SECRET="ITGATE";
  long EXPIRATION=360000000;//1h le temps d'expiration
   String HEADER_PREFIX="Bearer ";
}
