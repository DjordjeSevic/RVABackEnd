--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-05-07 01:08:14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3341 (class 1262 OID 16394)
-- Name: rvaFakultet; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "rvaFakultet" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';


ALTER DATABASE "rvaFakultet" OWNER TO postgres;

\connect "rvaFakultet"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16405)
-- Name: departman; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departman (
    id integer NOT NULL,
    naziv character varying(100),
    oznaka character varying(10),
    fakultet integer NOT NULL
);


ALTER TABLE public.departman OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16439)
-- Name: departman_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.departman_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departman_id_seq OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16395)
-- Name: fakultet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fakultet (
    id integer NOT NULL,
    naziv character varying(100),
    sediste character varying(50)
);


ALTER TABLE public.fakultet OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16437)
-- Name: fakultet_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fakultet_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fakultet_id_seq OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16400)
-- Name: status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status (
    id integer NOT NULL,
    naziv character varying(100),
    oznaka character varying(10)
);


ALTER TABLE public.status OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16438)
-- Name: status_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.status_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_id_seq OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16415)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    id integer NOT NULL,
    ime character varying(50),
    prezime character varying(50),
    broj_indeksa character varying(20),
    status integer NOT NULL,
    departman integer NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16440)
-- Name: student_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_id_seq OWNER TO postgres;

--
-- TOC entry 3186 (class 2606 OID 16409)
-- Name: departman departman_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departman
    ADD CONSTRAINT departman_pkey PRIMARY KEY (id);


--
-- TOC entry 3180 (class 2606 OID 16399)
-- Name: fakultet fakultet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fakultet
    ADD CONSTRAINT fakultet_pkey PRIMARY KEY (id);


--
-- TOC entry 3184 (class 2606 OID 16404)
-- Name: status status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- TOC entry 3193 (class 2606 OID 16419)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 3187 (class 1259 OID 16434)
-- Name: idx_fk_departman_fakultet; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_fk_departman_fakultet ON public.departman USING btree (fakultet);


--
-- TOC entry 3189 (class 1259 OID 16436)
-- Name: idx_fk_student_departman; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_fk_student_departman ON public.student USING btree (departman);


--
-- TOC entry 3190 (class 1259 OID 16435)
-- Name: idx_fk_student_status; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_fk_student_status ON public.student USING btree (status);


--
-- TOC entry 3188 (class 1259 OID 16432)
-- Name: idx_pk_departman; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_pk_departman ON public.departman USING btree (id);


--
-- TOC entry 3181 (class 1259 OID 16430)
-- Name: idx_pk_fakultet; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_pk_fakultet ON public.fakultet USING btree (id);


--
-- TOC entry 3182 (class 1259 OID 16431)
-- Name: idx_pk_status; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_pk_status ON public.status USING btree (id);


--
-- TOC entry 3191 (class 1259 OID 16433)
-- Name: idx_pk_student; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_pk_student ON public.student USING btree (id);


--
-- TOC entry 3194 (class 2606 OID 16410)
-- Name: departman fk_departman_fakultet; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departman
    ADD CONSTRAINT fk_departman_fakultet FOREIGN KEY (fakultet) REFERENCES public.fakultet(id);


--
-- TOC entry 3196 (class 2606 OID 16425)
-- Name: student fk_student_departman; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT fk_student_departman FOREIGN KEY (departman) REFERENCES public.departman(id);


--
-- TOC entry 3195 (class 2606 OID 16420)
-- Name: student fk_student_status; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT fk_student_status FOREIGN KEY (status) REFERENCES public.status(id);


-- Completed on 2022-05-07 01:08:14

--
-- PostgreSQL database dump complete
--

