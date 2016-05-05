DROP SCHEMA IF EXISTS SpringApp CASCADE;
create schema SpringApp;


ALTER SCHEMA SpringApp OWNER TO developer;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = SpringApp, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;