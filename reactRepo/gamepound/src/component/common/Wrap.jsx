import React from 'react';
import styled from 'styled-components';
import Header from './header/Header';
import Footer from './footer/Footer';
import Main from './main/Main';

const StyledWrapDiv = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
`;

const Wrap = () => {
    return (
        <StyledWrapDiv>
            <Header />
            <Main />
            <Footer />
        </StyledWrapDiv>
    );
};

export default Wrap;