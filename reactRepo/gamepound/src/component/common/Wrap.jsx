import React from 'react';
import styled from 'styled-components';
import Header from './header/Header';
import Footer from './footer/Footer';
import Main from './main/Main';
import { HeaderMemoryProvider } from '../context/HeaderContext';

const StyledWrapDiv = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
`;

const Wrap = () => {
    return (
        <HeaderMemoryProvider>
            <StyledWrapDiv>
                <Header />
                <Main />
                <Footer />
            </StyledWrapDiv>
        </HeaderMemoryProvider>
    );
};

export default Wrap;