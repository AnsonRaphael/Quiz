import React from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';
import CustomRoute from './CustomRoute';
import AccessDenied from './AccessDenied/AccessDenied';
import PageNotFound from './PageNotFound/PageNotFound';
import Login from '../components/pages/login/Login';
import SignUp from '../components/pages/signup/Signup'
import { CssBaseline, ThemeProvider } from '@material-ui/core';
import Theme from './Utils/Theme';
//<ThemeProvider theme={Theme}>

function RootRouter(params) {
    return (
        <ThemeProvider theme={Theme}>
            <CssBaseline />
            <Switch>
                <Redirect exact from="/" to="login" />
                <Route exact path='/access-denied' component={AccessDenied} />
                <CustomRoute exact path='/404' component={PageNotFound} />
                <CustomRoute exact path='/login' component={Login} />
                <CustomRoute exact path='/home' component={Login} />
                <CustomRoute exact path='/SignUp' component={SignUp} />
                <CustomRoute component={PageNotFound} />
            </Switch>
        </ThemeProvider>
    );
}

export default RootRouter;